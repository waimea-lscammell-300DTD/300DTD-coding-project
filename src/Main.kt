/**
 * ------------------------------------------------------------------------
 * Waimea dating Sim
 * Level 3 programming project
 *
 * by Luke Scammell
 *
 * The project involves the programming of a game.

 * You are a new student at Waimea College and you meet some of the students your objective is to use your talking skills to attract your partner
 
 * You will pick a response from 4 options and what you choose will change how people think of you and might affect what other peoples responses
 * ------------------------------------------------------------------------
 */


import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*

class Scene(
    val name:String,
    val desc:String,
    val img:String,
    val isdeath:Boolean = false,
    val isdenial:Boolean = false
) {
    var choice1Link: Scene? = null
    var choice2Link: Scene? = null
    var choice3Link: Scene? = null
    var choice4Link: Scene? = null

    var choice1Label: String? = null
    var choice2Label: String? = null
    var choice3Label: String? = null
    var choice4Label: String? = null
//
//    var choice1sound: String? = null
//    var choice2sound: String? = null
//    var choice3sound: String? = null
//    var choice4sound: String? = null

    fun addConnection(choiceNum: Int, label: String, scene: Scene) {
        when (choiceNum) {
            1 -> {
                choice1Link = scene
                choice1Label = label
//                choice1sound = sound
            }
            2 -> {
                choice2Link = scene
                choice2Label = label
            }
            3 -> {
                choice3Link = scene
                choice3Label = label
            }
            4 -> {
                choice4Link = scene
                choice4Label = label
            }
        }
    }
}

//=============================================================================================

/**
 * GUI class
 * Defines the UI and responds to events
 */
class GUI : JFrame(), ActionListener {
    val scenes = mutableListOf<Scene>()
    var currentScene: Scene
    var deaths = 0
    var denial = 0

    // Setup some properties to hold the UI elements
    private lateinit var descriptionLabel: JLabel
//    private lateinit var deathCounter: JLabel
//    private lateinit var denyCounter: JLabel
    private lateinit var choice1Button: JButton
    private lateinit var choice2Button: JButton
    private lateinit var choice3Button: JButton
    private lateinit var choice4Button: JButton
    private lateinit var imageLabel: JLabel
    private lateinit var deathsLabel: JLabel
    private lateinit var denialLabel: JLabel


    /**
     * Create, build and run the UI
     */
    init {
        setupScenes()
        setupWindow()
        buildUI()



        // Show the app, centred on screen
        setLocationRelativeTo(null)
        isVisible = true

        currentScene = scenes.first()
        showScene()
    }
    fun setupScenes() {
        // Starting scene
        val chicken =  Scene("scout chicken","Scout appears and walks slowly up to you, he says 'do you have a bucket of chicken?'", "src/images/scout.png")
        scenes.add(chicken)

        // Scene 1 answers
        val yes =  Scene("yes","yes", "src/images/scout happy.png")
        val no =  Scene("no","no", "src/images/scout sad.png")
        val goaway =  Scene("go away","go away", "src/images/Scout suprised.png")
        val share =  Scene("share","Really you would want to share with me?", "src/images/scout chicken costume.png")
        scenes.add(yes)
        scenes.add(no)
        scenes.add(goaway)
        scenes.add(share)
        chicken.addConnection(1, "yes", yes)
        chicken.addConnection(2, "no", no)
        chicken.addConnection(3, "go away", goaway)
        chicken.addConnection(4, "share", share)


        // Yes
        val eat =  Scene("eat ","eating chicken* some other mercenaries arrive. Who would you like to talk to?", "src/images/scout chicken costume.png")
        val take =  Scene("take ","takes chicken*", "src/images/Scout suprised.png")
        val cook =  Scene("cook","cooks the chicken some more*", "src/images/chicken hat.png")
        scenes.add(eat)
        scenes.add(take)
        scenes.add(cook)
        yes.addConnection(1, "eat", eat)
        yes.addConnection(2, "take", take)
        yes.addConnection(3, "cook", cook)

        // No
        val deny   =  Scene("deny ","ok ill just eat them myself :(", "src/images/scout sad.png")
        scenes.add(deny)
        no.addConnection(1, "deny", deny)

        // Go away
        val deny2  = Scene("deny ","ok ill just eat them myself :(", "src/images/Scout cry.png")
        scenes.add(deny2)
        goaway.addConnection(1, "deny", deny2)

        // Share
        val yeah  =  Scene("Finish Cooking","'yay' scout takes chicken*", "src/images/chicken hat.png")
        val Iwasjoking  =  Scene("I was Joking","Why would you lie to me ;(", "src/images/Scout cry.png")
        scenes.add(yeah)
        scenes.add(Iwasjoking)
        share.addConnection(1, "yeah", yeah)
        share.addConnection(2, "I was Joking", Iwasjoking)
        yeah.addConnection(1, "Talk with someone else", chicken)

        // Cook
        val finishcooking  =  Scene("Finish Cooking","You cook the chicken and it looks even tastier", "src/images/chicken hat.png")
        scenes.add(finishcooking)
        cook.addConnection(1, "finish cooking", finishcooking)
        finishcooking.addConnection(1, "Finish cooking", yes)

        // Eat
        val pyromeet =  Scene("meet pyro","Pyro appears and says hello", "src/images/pyro.png")
        val heavymeet  =  Scene("meet heavy","Heavy appears and says hello", "src/images/Heavy.png")
        val medicmeet =  Scene("meet medic","Medic appears and says hello", "src/images/medic.png")
        val spymeet =  Scene("meet spy","Spy appears and says hello", "src/images/Spy.png")
        scenes.add(heavymeet)
        scenes.add(pyromeet)
        scenes.add(medicmeet)
        scenes.add(spymeet)
        eat.addConnection(1, "Say hello to heavy", heavymeet)
        eat.addConnection(2, "Say hello to pyro", pyromeet)
        eat.addConnection(3, "Say hello to medic", medicmeet)
        eat.addConnection(4, "Say hello to spy", spymeet)

        // Heavy
        val makefunsasha = Scene("Make fun of sasha","Sasha is stupid", "src/images/Heavy with sasha.png")
        val askaboutsisters = Scene("ask about sisters","My sisters are doing well, I haven't been able to see them recently though", "src/images/pyro.png")
        heavymeet.addConnection(1, "Make fun of sasha", makefunsasha)
        heavymeet.addConnection(2, "Ask about sisters", askaboutsisters)
        askaboutsisters.addConnection(1, "Talk with someone else", eat)

        // Pyro
        val pyrohitsapple = Scene("Apple challenge","Pyro aims her flare gun at the apple on your head", "src/images/pyro.png")
        val askaboutpyrogender = Scene("ask about pyro gender","I am a girl :3", "src/images/Fempyro.png")
        val givealollipop = Scene("ask about pyro gender","THANK YOU LOLLYPOPS ARE MY FAVORITE", "src/images/Lollypop pyro.png")
        scenes.add(pyrohitsapple)
        scenes.add(askaboutpyrogender)
        scenes.add(givealollipop)
        pyromeet.addConnection(1, "Apple challenge", pyrohitsapple)
        pyromeet.addConnection(2, "Are you a guy or a girl", askaboutpyrogender)
        pyromeet.addConnection(3, "Here is a lollypop", givealollipop)
        askaboutpyrogender.addConnection(1, "Talk with someone else", eat)
        givealollipop.addConnection(1, "Talk with someone else", eat)

        // Medic
        val someoneneedshealing = Scene("Tell medic someone needs healing","Ok Ill go heal them, thanks for telling me","src/images/healing medic.png")
        val medicisbad = Scene("tell medic he is a bad medic","Oh is that what you think of me, I guess you deserve to die","src/images/medic angry.png")
        val dance = Scene("dance with medic","LETS HAVE A PARTY starts dancing*","src/images/dancing medic.png")
        scenes.add(someoneneedshealing)
        scenes.add(medicisbad)
        scenes.add(dance)
        medicmeet.addConnection(1, "Someone needs healing", someoneneedshealing)
        medicmeet.addConnection(2, "You are a terrible medic", medicisbad)
        medicmeet.addConnection(3, "Wanna dance?", dance)
        someoneneedshealing.addConnection(1, "Talk with someone else", eat)
        dance.addConnection(1, "Talk with someone else", eat)

        // Spy
        val stealcigarettes = Scene("steal cigarettes","Where did my ciggarettes go?","src/images/angry spy.png")
        val askaboutscout = Scene("ask how is scout","He doesnt know yet, if you tell him I will kill you","src/images/helicopter spy.png")
        val spycrab = Scene("spy shows spycrab","Starts crawling around like a crab","src/images/Spy crab.png")
        scenes.add(stealcigarettes)
        scenes.add(askaboutscout)
        scenes.add(spycrab)
        spymeet.addConnection(1, "Steal spies cigarettes", stealcigarettes)
        spymeet.addConnection(2, "spy is scouts dad", askaboutscout)
        spymeet.addConnection(3, "show me the spy crab", spycrab)
        askaboutscout.addConnection(1, "Talk with someone else", eat)
        spycrab.addConnection(1, "Talk with someone else", eat)

        // Things that bring you back to the start
        val denial = Scene("denial","Scout walks away sadly", "src/images/scout sad.png",false, true)
        val death = Scene("You died!", "scout didn't like you taking his chicken", "src/images/scout with gun.png", true)
        val death2 = Scene("You died!", "scout doesn't like liars", "src/images/scout with gun.png", true)
        val death3 = Scene("You died!", "Sasha is great gun you must praise her", "src/images/heavy angry.png", true)
        val death4 = Scene("You died!", "Pyro hit you with a flare", "src/images/Pyro flare.png", true)
        val death5 = Scene("You died!", "Medic stabbed you with his ubersaw", "src/images/ubersaw medic.png",true)
        val death6 = Scene("You died!", "As you were walking away spy found out you stole his cigarettes and backstabbs you", "src/images/spy backstab.png",true)
        scenes.add(denial)
        scenes.add(death)
        scenes.add(death2)
        scenes.add(death3)
        scenes.add(death4)
        scenes.add(death5)
        scenes.add(death6)
        take.addConnection(1, "Take it", death)
        Iwasjoking.addConnection(1, "I was joking", death2)
        makefunsasha.addConnection(1, "Sasha is stupid", death3)
        pyrohitsapple.addConnection(1, "Get hit by Flare", death4)
        medicisbad.addConnection(1, "Get impaled by medic", death5)
        stealcigarettes.addConnection(1, "Get backstabbed by spy", death6)
        deny.addConnection(1, "Scout leaves", denial)
        deny2.addConnection(1, "Scout leaves", denial)
        death.addConnection(1, "Restart", chicken)
        death2.addConnection(1, "Restart", chicken)
        death3.addConnection(1, "Restart", chicken)
        death4.addConnection(1, "Restart", chicken)
        death5.addConnection(1, "Restart", chicken)
        death6.addConnection(1, "Restart", chicken)
        denial.addConnection(1, "Restart", chicken)
    }

    /**
     * Configure the main window
     */
    private fun setupWindow() {
        title = "Hello, World!"
        contentPane.preferredSize = Dimension(1500, 1000)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI
     */
    private fun buildUI() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 20)

        descriptionLabel = JLabel("Scout appears and walks slowly up to you, he says 'do you have a bucket of chicken?'", SwingConstants.CENTER)
        descriptionLabel.bounds = Rectangle(350, 50, 800, 40)
        descriptionLabel.font = baseFont
        add(descriptionLabel)

        choice1Button = JButton("Choice 1")
        choice1Button.bounds = Rectangle(150,650,250,50)
        choice1Button.font = baseFont
        choice1Button.addActionListener(this)
        add(choice1Button)

        choice2Button = JButton("Choice 2")
        choice2Button.bounds = Rectangle(450,650,250,50)
        choice2Button.font = baseFont
        choice2Button.addActionListener(this)
        add(choice2Button)

        choice3Button = JButton("Choice 3")
        choice3Button.bounds = Rectangle(800,650,250,50)
        choice3Button.font = baseFont
        choice3Button.addActionListener(this)
        add(choice3Button)

        choice4Button = JButton("Choice 4")
        choice4Button.bounds = Rectangle(1100,650,250,50)
        choice4Button.font = baseFont
        choice4Button.addActionListener(this)
        add(choice4Button)

        imageLabel = JLabel()
        imageLabel.bounds = Rectangle(550, 150, 400, 400)
        add(imageLabel)

        deathsLabel= JLabel("Deaths: $deaths")
        deathsLabel.bounds = Rectangle(50, 900, 800, 40)
        deathsLabel.font = baseFont
        add(deathsLabel)

        denialLabel= JLabel("Deaths: $deaths")
        denialLabel.bounds = Rectangle(1350, 900, 800, 40)
        denialLabel.font = baseFont
        add(denialLabel)
    }

    /**
     * Handle any UI events
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            choice1Button -> choice1Action()
            choice2Button -> choice2Action()
            choice3Button -> choice3Action()
            choice4Button -> choice4Action()
        }
    }
    private fun showScene() {
        descriptionLabel.text = currentScene.desc

        if (currentScene.choice1Link != null) {
            choice1Button.text = currentScene.choice1Label
            choice1Button.isVisible = true
        }
        else {
            choice1Button.isVisible = false
        }

        if (currentScene.choice2Link != null) {
            choice2Button.text = currentScene.choice2Label
            choice2Button.isVisible = true
        }
        else {
            choice2Button.isVisible = false
        }

        if (currentScene.choice3Link != null) {
            choice3Button.text = currentScene.choice3Label
            choice3Button.isVisible = true
        }
        else {
            choice3Button.isVisible = false
        }

        if (currentScene.choice4Link != null) {
            choice4Button.text = currentScene.choice4Label
            choice4Button.isVisible = true
        }
        else {
            choice4Button.isVisible = false
        }

        var image = ImageIcon(currentScene.img).image
        image = image.getScaledInstance(400, 400, Image.SCALE_SMOOTH)
        imageLabel.icon = ImageIcon(image)

        if (currentScene.isdeath) {
            deaths++
        }
        if (currentScene.isdenial) {
            denial++
        }

        deathsLabel.text = "Deaths: $deaths"
        denialLabel.text = "Denial: $denial"
    }
    /**
     * An Example Action
     */
    private fun choice1Action() {
        currentScene = currentScene.choice1Link!!
        showScene()
    }
    private fun choice2Action() {
        currentScene = currentScene.choice2Link!!
        showScene()
    }
    private fun choice3Action() {
        currentScene = currentScene.choice3Link!!
        showScene()
    }
    private fun  choice4Action() {
        currentScene = currentScene.choice4Link!!
        showScene()
    }

//    private fun deathcounter(){
//
//    }
//    private fun denycounter(){
//
//    }
}


//=============================================================================================

/**
 * Launch the application
 */
fun main() {
    // Flat, Dark look-and-feel
    FlatDarkLaf.setup()

    // Create the UI
    GUI()
}



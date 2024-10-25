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
) {
    var choice1Link: Scene? = null
    var choice2Link: Scene? = null
    var choice3Link: Scene? = null
    var choice4Link: Scene? = null

    var choice1Label: String? = null
    var choice2Label: String? = null
    var choice3Label: String? = null
    var choice4Label: String? = null

    fun addConnection(choiceNum: Int, label: String, scene: Scene) {
        when (choiceNum) {
            1 -> {
                choice1Link = scene
                choice1Label = label
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

    // Setup some properties to hold the UI elements
    private lateinit var descriptionLabel: JLabel
    private lateinit var choice1Button: JButton
    private lateinit var choice2Button: JButton
    private lateinit var choice3Button: JButton
    private lateinit var choice4Button: JButton
    private lateinit var imageLabel: JLabel

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
        // Level 0
        val chicken =  Scene("scout chicken","Scout appears and walks slowly up to you, he says 'do you have a bucket of chicken?'", "src/images/scout.png")
        scenes.add(chicken)

        // Level 1
        val yes =  Scene("yes","yes", "src/images/medic.png")
        val no =  Scene("no","no", "src/images/ubersaw medic.png")
        val goaway =  Scene("go away","go away", "src/images/medic.png")
        val share =  Scene("share","I've allready got some would you like to share?", "src/images/ubersaw medic.png")
        scenes.add(yes)
        scenes.add(no)
        scenes.add(goaway)
        scenes.add(share)
        chicken.addConnection(1, "yes", yes)
        chicken.addConnection(2, "no", no)
        chicken.addConnection(3, "go away", goaway)
        chicken.addConnection(4, "smile", share)


        // Yes
        val eat =  Scene("eat ","eating chicken*", "src/images/medic.png")
        val take =  Scene("take ","takes chicken*", "src/images/ubersaw medic.png")
        val cook =  Scene("cook","cookes the chicken some more*", "src/images/medic.png")
        scenes.add(eat)
        scenes.add(take)
        scenes.add(cook)
        yes.addConnection(1, "eat", eat)
        yes.addConnection(2, "take", take)
        yes.addConnection(3, "cook", cook)

        // No
        val deny   =  Scene("deny ","ok ill just eat them myself :(", "src/images/medic.png")
        scenes.add(eat)
        no.addConnection(1, "deny", deny)

        // Cook
        val finishcooking  =  Scene("Finish Cooking","You cook the chicken and it looks even tastier", "src/images/medic.png")
        cook.addConnection(3, "finish cooking", finishcooking)
        finishcooking.addConnection(1, "Finish cooking", yes)


        // Things that bring you back to the start
        val denial = Scene("denial","Scout walks away sadly", "src/images/medic.png")
        val death = Scene("You died!", "scout didnt like you taking his chicken", "src/images/death.png")
        take.addConnection(1, "Take it", death)
        deny.addConnection(1, "Scout leaves", denial)
        death.addConnection(1, "Restart", chicken)
        denial.addConnection(1, "Restart", chicken)
    }

    /**
     * Configure the main window
     */
    private fun setupWindow() {
        title = "Hello, World!"
        contentPane.preferredSize = Dimension(1000, 500)
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
        descriptionLabel.bounds = Rectangle(100, 10, 800, 40)
        descriptionLabel.font = baseFont
        add(descriptionLabel)

        choice1Button = JButton("Choice 1")
        choice1Button.bounds = Rectangle(125,350,150,50)
        choice1Button.font = baseFont
        choice1Button.addActionListener(this)
        add(choice1Button)

        choice2Button = JButton("Choice 2")
        choice2Button.bounds = Rectangle(325,350,150,50)
        choice2Button.font = baseFont
        choice2Button.addActionListener(this)
        add(choice2Button)

        choice3Button = JButton("Choice 3")
        choice3Button.bounds = Rectangle(525,350,150,50)
        choice3Button.font = baseFont
        choice3Button.addActionListener(this)
        add(choice3Button)

        choice4Button = JButton("Choice 4")
        choice4Button.bounds = Rectangle(725,350,150,50)
        choice4Button.font = baseFont
        choice4Button.addActionListener(this)
        add(choice4Button)

        imageLabel = JLabel()
        imageLabel.bounds = Rectangle(400, 50, 200, 200)
        add(imageLabel)
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
        image = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)
        imageLabel.icon = ImageIcon(image)
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



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
import com.formdev.flatlaf.FlatLightLaf
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

    fun addConnection(choiceNum: Int, scene: Scene) {
        when (choiceNum) {
            1 -> choice1Link = scene
            2 -> choice2Link = scene
            3 -> choice3Link = scene
            4 -> choice4Link = scene
        }
    }
}

//=============================================================================================

/**
 * GUI class
 * Defines the UI and responds to events
 */
class GUI : JFrame(), ActionListener {

    // Setup some properties to hold the UI elements
    private lateinit var exampleLabel: JLabel
    private lateinit var choice1Button: JButton
    private lateinit var choice2Button: JButton
    private lateinit var choice3Button: JButton
    private lateinit var choice4Button: JButton
    private lateinit var imageLabel: JLabel
    private lateinit var choice1Scene1: JButton
    private lateinit var choice2Scene1: JButton
    private lateinit var choice3Scene1: JButton
    private lateinit var choice4Scene1: JButton


    private lateinit var scoutImageIcon: ImageIcon

    /**
     * Create, build and run the UI
     */
    init {
        setupWindow()
        buildUI()
        loadImages()


        // Show the app, centred on screen
        setLocationRelativeTo(null)
        isVisible = true
    }
    fun setupChoice() {
        val choice1scene1 =         Scene(")

        val choice2scene1 = Scene("no")

        val choice3scene1 = Scene("go away")

        val choice3scene1 = JButton("yes, but I've eaten it all")

    }

    private fun loadImages(){
        var scout = ImageIcon("src/images/250px-Taunt_Deep_Fried_Desire.png").image
        scout = scout.getScaledInstance(200, 200, Image.SCALE_SMOOTH)
        scoutImageIcon = ImageIcon(scout)

        imageLabel.icon = scoutImageIcon
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

        exampleLabel = JLabel("Scout appears and walks slowly up to you, he says 'do you have a bucket of chicken?'", SwingConstants.CENTER)
        exampleLabel.bounds = Rectangle(100, 10, 800, 40)
        exampleLabel.font = baseFont
        add(exampleLabel)

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

    /**
     * An Example Action
     */
    private fun choice1Action() {
        exampleLabel.text = "yes"
    }
    private fun choice2Action() {
        exampleLabel.text = "no"
    }
    private fun choice3Action() {
        exampleLabel.text = "go away"
    }
    private fun  choice4Action() {
        exampleLabel.text = "yes, but I've eaten it all"
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



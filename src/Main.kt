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
    private fun loadImages(){
        var scout = ImageIcon("src/images/6574.png").image
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

        exampleLabel = JLabel("Hello, World!", SwingConstants.CENTER)
        exampleLabel.bounds = Rectangle(425, 30, 150, 40)
        exampleLabel.font = baseFont
        add(exampleLabel)

        choice1Button = JButton("Choice 1")
        choice1Button.bounds = Rectangle(125,275,150,50)
        choice1Button.font = baseFont
        choice1Button.addActionListener(this)
        add(choice1Button)

        choice2Button = JButton("Choice 2")
        choice2Button.bounds = Rectangle(325,275,150,50)
        choice2Button.font = baseFont
        choice2Button.addActionListener(this)
        add(choice2Button)

        choice3Button = JButton("Choice 3")
        choice3Button.bounds = Rectangle(525,275,150,50)
        choice3Button.font = baseFont
        choice3Button.addActionListener(this)
        add(choice3Button)

        choice4Button = JButton("Choice 4")
        choice4Button.bounds = Rectangle(725,275,150,50)
        choice4Button.font = baseFont
        choice4Button.addActionListener(this)
        add(choice4Button)

        imageLabel = JLabel()
        imageLabel.bounds = Rectangle(50, 200, 200, 200)
        add(imageLabel)
    }

    /**
     * Handle any UI events
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            choice1Button -> exampleAction()
            choice2Button -> exampleAction()
            choice3Button -> exampleAction()
            choice4Button -> exampleAction()
        }
    }

    /**
     * An Example Action
     */
    private fun exampleAction() {
        exampleLabel.text = "You Clicked!"
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



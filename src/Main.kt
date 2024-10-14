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
    private lateinit var exampleButton: JButton

    /**
     * Create, build and run the UI
     */
    init {
        setupWindow()
        buildUI()

        // Show the app, centred on screen
        setLocationRelativeTo(null)
        isVisible = true
    }

    /**
     * Configure the main window
     */
    private fun setupWindow() {
        title = "Hello, World!"
        contentPane.preferredSize = Dimension(300, 170)
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
        exampleLabel.bounds = Rectangle(30, 30, 240, 40)
        exampleLabel.font = baseFont
        add(exampleLabel)

        exampleButton = JButton("Click Me")
        exampleButton.bounds = Rectangle(30,100,240,40)
        exampleButton.font = baseFont
        exampleButton.addActionListener(this)
        add(exampleButton)
    }

    /**
     * Handle any UI events
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            exampleButton -> exampleAction()
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



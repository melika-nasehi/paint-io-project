import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    JRadioButton easy = new JRadioButton();
    JRadioButton medium = new JRadioButton();
    JRadioButton hard = new JRadioButton();
    ButtonGroup difficultyGroup = new ButtonGroup();
    JLabel difficultyLabel = new JLabel("Difficulty : ");
    JLabel blank1 = new JLabel("     ") ;
    JLabel blank2 = new JLabel("     ") ;
    JLabel blank3 = new JLabel("     ") ;
    JLabel blank4 = new JLabel("     ") ;
    JLabel blank5 = new JLabel("     ") ;
    JLabel blank6 = new JLabel("     ") ;
    JLabel blank7 = new JLabel("     ") ;
    JLabel blank8 = new JLabel("     ") ;
    JLabel speedLabel = new JLabel("Speed : ") ;
    SpinnerNumberModel spinnerModel1 = new SpinnerNumberModel(6, 1, 15, 0.5);
    JSpinner speedSpinner = new JSpinner(spinnerModel1 ) ;
    SpinnerNumberModel spinnerModel2 = new SpinnerNumberModel(2, 0, 4, 1);
    JSpinner enemySpinner = new JSpinner(spinnerModel2 ) ;
    JLabel enemyLabel = new JLabel("          Enemy Count :") ;
    JLabel characterLabel = new JLabel("choose your character :      ") ;
    ButtonGroup characterGroup = new ButtonGroup();
    JRadioButton rabbit = new JRadioButton();
    JLabel rabbitLabel = new JLabel();
    JLabel rabbitLabel2 = new JLabel();
    JRadioButton rainbow = new JRadioButton();
    JLabel rainbowLabel2 = new JLabel();
    JLabel rainbowLabel = new JLabel();
    JLabel fieldLabel = new JLabel("choose game field :    ") ;
    JLabel grayField = new JLabel() ;
    JLabel plainField = new JLabel() ;
    JLabel pinkField = new JLabel() ;
    JLabel blueField = new JLabel() ;
    JRadioButton gray = new JRadioButton();
    JRadioButton plain = new JRadioButton();
    JRadioButton pink = new JRadioButton();
    JRadioButton blue = new JRadioButton();
    ButtonGroup fieldGroup = new ButtonGroup();





    public Menu() {

        // Set up the frame properties
        setTitle("Game Menu");
        setSize( 1320  ,744);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the menu components
        JPanel panel = new JPanel();
        JPanel rowPanel1 = new JPanel();
        JPanel rowPanel2 = new JPanel();
        JPanel rowPanel3 = new JPanel();
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (easy.isSelected()) {
                    Enemy.upNumber = 5 ;
                    Enemy.downNumber = 10 ;
                    Enemy.rightNumber = 15 ;
                    Enemy.leftNumber = 20 ;
                }


                else if (medium.isSelected()){
                    Enemy.upNumber = 20 ;
                    Enemy.downNumber = 30 ;
                    Enemy.rightNumber = 45 ;
                    Enemy.leftNumber = 50 ;
                }

                else if (hard.isSelected()){
                    Enemy.upNumber = 25 ;
                    Enemy.downNumber = 50 ;
                    Enemy.rightNumber = 75 ;
                    Enemy.leftNumber = 100 ;
                }

                GamePanel.fps = (double) speedSpinner.getValue();
                GamePanel.userSelectedEnemyCount = (int) enemySpinner.getValue();

                if (rabbit.isSelected()) {
                    Player.imagePath = "/images/rabbit.png" ;
                    TileFactory.lightColor = "/images/light carrot.png" ;
                    TileFactory.solidColor = "/images/carrot tile.png" ;
                }
                else if (rainbow.isSelected()){
                    Player.imagePath = "/images/rainbow.png" ;
                    TileFactory.lightColor = "/images/light rainbow.png" ;
                    TileFactory.solidColor = "/images/rainbow tile.png" ;
                }

                if (gray.isSelected()) {
                    TileFactory.contrastTile = 0 ;
                }
                else if (plain.isSelected()){
                    TileFactory.contrastTile = 1 ;
                }
                else if (pink.isSelected()){
                    TileFactory.contrastTile = 27 ;
                }
                else if (blue.isSelected()){
                    TileFactory.contrastTile = 28 ;
                }

                dispose(); // Close the menu screen
                GameScreen gameScreen = new GameScreen();
                gameScreen.startGame();
            }
        });
        JLabel titleLabel = new JLabel("Paint IO Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        blank1.setFont(new Font("Arial", Font.BOLD, 30));
        blank2.setFont(new Font("Arial", Font.BOLD, 20));
        blank3.setFont(new Font("Arial", Font.BOLD, 30));
        blank4.setFont(new Font("Arial", Font.BOLD, 30));
        blank5.setFont(new Font("Arial", Font.BOLD, 30));
        blank6.setFont(new Font("Arial", Font.BOLD, 30));
        blank7.setFont(new Font("Arial", Font.BOLD, 30));
        blank8.setFont(new Font("Arial", Font.BOLD, 30));
        easy.setFont(new Font("" , Font.PLAIN , 15));
        medium.setFont(new Font("" , Font.PLAIN , 15));
        hard.setFont(new Font("" , Font.PLAIN , 15));
        difficultyLabel.setFont(new Font("Arial", Font.BOLD, 20));
        speedLabel.setFont(new Font("" , Font.BOLD , 20));
        enemyLabel.setFont(new Font("" , Font.BOLD , 20));
        characterLabel.setFont(new Font("" , Font.BOLD , 20));
        fieldLabel.setFont(new Font("" , Font.BOLD , 20));


        easy.setText("Easy");
        medium.setText("Medium");
        hard.setText("Hard");
        difficultyGroup.add(easy);
        difficultyGroup.add(medium);
        difficultyGroup.add(hard);
        easy.setSelected(true);

        rabbit.setText("             ");
        rainbow.setText("             ");
        characterGroup.add(rabbit);
        characterGroup.add(rainbow);
        rabbit.setSelected(true);

        gray.setText("             ");
        plain.setText("             ");
        pink.setText("             ");
        blue.setText("             ");
        fieldGroup.add(gray);
        fieldGroup.add(plain);
        fieldGroup.add(pink);
        fieldGroup.add(blue);
        plain.setSelected(true);

        speedSpinner.setPreferredSize(new Dimension(50 , 30));
        enemySpinner.setPreferredSize(new Dimension(50, 30));

        rabbitLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/rabbit.png")).
                getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        rainbowLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/rainbow.png")).
                getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        rabbitLabel2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/carrot tile.png")).
                getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
        rainbowLabel2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/rainbow tile.png")).
                getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
        grayField.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/gray field.png")).
                getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        plainField.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/plain field.png")).
                getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        pinkField.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/pink field.png")).
                getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        blueField.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/blue field.png")).
                getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));



        // Add components to the panel
        panel.setLayout(new BoxLayout(panel , BoxLayout.Y_AXIS));
        rowPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        rowPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        rowPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(titleLabel);
        panel.add(blank1);
        panel.add(difficultyLabel);
        panel.add(easy) ;
        panel.add(medium ) ;
        panel.add(hard ) ;
        panel.add(blank2);

        rowPanel1.add(characterLabel) ;
        rowPanel1.add(rabbitLabel2);
        rowPanel1.add(rabbitLabel);
        rowPanel1.add(rabbit) ;
        rowPanel1.add(rainbowLabel2);
        rowPanel1.add(rainbowLabel);
        rowPanel1.add(rainbow) ;

        rowPanel2.add(speedLabel);
        rowPanel2.add(speedSpinner) ;
        rowPanel2.add(enemyLabel);
        rowPanel2.add(enemySpinner);

        rowPanel3.add(fieldLabel) ;
        rowPanel3.add(plainField);
        rowPanel3.add(plain);
        rowPanel3.add(grayField);
        rowPanel3.add(gray);
        rowPanel3.add(pinkField);
        rowPanel3.add(pink);
        rowPanel3.add(blueField);
        rowPanel3.add(blue);

        panel.add(rowPanel1) ;
        panel.add(rowPanel2);
        panel.add(rowPanel3);

        panel.add(startButton);



        // Set the panel as the content pane of the frame
        setContentPane(panel);

    }

}

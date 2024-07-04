import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main implements ActionListener {
    JFrame f = new JFrame("Character Generator");
    Random r = new Random();
    JButton generate = new JButton("Generate");
    JButton clear = new JButton("Clear");
    JLabel characterClass = new JLabel("Style", JLabel.CENTER);
    JLabel characterClass2 = new JLabel("Race", JLabel.CENTER);
    JLabel characterClass3 = new JLabel("Weapon", JLabel.CENTER);

    JLabel newGenerate = new JLabel("?", JLabel.CENTER);
    JLabel newGenerate2 = new JLabel("?", JLabel.CENTER);
    JLabel newGenerate3 = new JLabel("?", JLabel.CENTER);

    Color custBlue = new Color(10, 63, 250);
    Color custOrange = new Color(251, 167, 88);
    Color saturatedCustOrange = new Color(254, 127, 46);

    // Load images using class loader
    ImageIcon wheel = new ImageIcon(getClass().getClassLoader().getResource("images/loading_wheel.gif"));
    JLabel img = new JLabel(wheel);
    ImageIcon back_image = new ImageIcon(getClass().getClassLoader().getResource("images/back_ground.png"));
    JLabel img2 = new JLabel(back_image);

    private String[] styles = {"<html><p align='center'>Steampunk</p></html>", "<html><p align='center'>Sci-Fi</p></html>", "<html><p align='center'>Medieval</p></html>", "<html><p align='center'>Imprisoned</p></html>", "<html><p align='center'>Superpowered</p></html>", "<html><p align='center'>Villainous</p></html>", "<html><p align='center'>Primal</p></html>", "<html><p align='center'>Musical</p></html>", "<html><p align='center'>Aquatic</p></html>", "<html><p align='center'>Undead</p></html>"};

    private String[] races = {"<html><p align='center'>Sorcerer</p></html>", "<html><p align='center'>Alien</p></html>", "<html><p align='center'>Knight</p></html>", "<html><p align='center'>Orc</p></html>", "<html><p align='center'>Elf</p></html>", "<html><p align='center'>Bear</p></html>", "<html><p align='center'>Human</p></html>", "<html><p align='center'>Vampire</p></html>", "<html><p align='center'>Werewolf</p></html>", "<html><p align='center'>Dwarf</p></html>"};

    private String[] weapons = {"<html><p align='center'>Bow<br />And Arrow</p></html>", "<html><p align='center'>Blade</p></html>", "<html><p align='center'>Gun</p></html>", "<html><p align='center'>Nunchucks</p></html>", "<html><p align='center'>Shield</p></html>", "<html><p align='center'>Bomb</p></html>", "<html><p align='center'>Claws</p></html>", "<html><p align='center'>Mace</p></html>", "<html><p align='center'>Axe</p></html>", "<html><p align='center'>Staff</p></html>"};

    private List<String> randomStyles = new ArrayList<>(10);
    private List<String> randomRaces = new ArrayList<>(10);
    private List<String> randomWeapons = new ArrayList<>(10);

    public static void main(String[] args) {
        Main o = new Main();
        o.gui();
    }

    public void gui() {
        f.setSize(500, 400);

        this.newGenerate.setBounds(132, 107, 180, 40);
        newGenerate.setFont(new Font("Arial", Font.BOLD, 20));
        this.newGenerate.setForeground(saturatedCustOrange);
        f.add(this.newGenerate);

        this.newGenerate2.setBounds(304, 107, 180, 40);
        newGenerate2.setFont(new Font("Arial", Font.BOLD, 20));
        this.newGenerate2.setForeground(saturatedCustOrange);
        f.add(this.newGenerate2);

        this.newGenerate3.setBounds(218, 250, 180, 40);
        newGenerate3.setFont(new Font("Arial", Font.BOLD, 20));
        this.newGenerate3.setForeground(saturatedCustOrange);
        f.add(this.newGenerate3);

        characterClass.setBounds(132, 50, 180, 40);
        characterClass.setFont(new Font("Arial", Font.BOLD, 20));
        this.characterClass.setForeground(saturatedCustOrange);
        f.add(this.characterClass);

        characterClass2.setBounds(304, 50, 180, 40);
        characterClass2.setFont(new Font("Arial", Font.BOLD, 20));
        this.characterClass2.setForeground(saturatedCustOrange);
        f.add(this.characterClass2);

        characterClass3.setBounds(218, 192, 180, 40);
        characterClass3.setFont(new Font("Arial", Font.BOLD, 20));
        this.characterClass3.setForeground(saturatedCustOrange);
        f.add(this.characterClass3);

        this.generate.setBounds(50, 240, 120, 40);
        generate.setFont(new Font("Arial", Font.BOLD, 16));
        this.generate.setForeground(custOrange);
        this.generate.setBackground(custBlue);
        this.generate.addActionListener(this);
        f.add(this.generate);

        this.clear.setBounds(50, 290, 120, 40);
        clear.setFont(new Font("Arial", Font.BOLD, 16));
        this.clear.setForeground(custOrange);
        this.clear.setBackground(custBlue);
        this.clear.addActionListener(this);
        f.add(this.clear);

        img.setBounds(0, -10, 500, 400);
        f.add(img);

        img2.setBounds(0, -10, 500, 400);
        f.add(img2);

        f.setLayout(null);
        f.setVisible(true);
    }

    public void usr_inpt() {

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.clear) {
            img.setVisible(true);
            this.generate.setForeground(custOrange);
            this.newGenerate.setText("?");
            this.newGenerate2.setText("?");
            this.newGenerate3.setText("?");
        } else {
            this.generate.setForeground(Color.GREEN);
            this.newGenerate.setText(this.returnStyle());
            this.newGenerate2.setText(this.returnRace());
            this.newGenerate3.setText(this.returnWeapon());
            img.setVisible(false);
        }
    }

    public String returnStyle() {
        if (randomStyles.isEmpty()) {
            randomStyles.addAll(Arrays.asList(styles));
            Collections.shuffle(randomStyles);
        }
        return randomStyles.remove(0);
    }

    public String returnRace() {
        if (randomRaces.isEmpty()) {
            randomRaces.addAll(Arrays.asList(races));
            Collections.shuffle(randomRaces);
        }
        return randomRaces.remove(0);
    }

    public String returnWeapon() {
        if (randomWeapons.isEmpty()) {
            randomWeapons.addAll(Arrays.asList(weapons));
            Collections.shuffle(randomWeapons);
        }
        return randomWeapons.remove(0);
    }
}


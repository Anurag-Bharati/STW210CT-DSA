package main.java.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GUI extends JFrame {
    DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
    int[][] graph;
    int distance;
    String route;

    // Node counter
    int count = 0;

    // Stores coordinate of nodes
    ArrayList<Integer> x_pos = new ArrayList<>();
    ArrayList<Integer> y_pos = new ArrayList<>();

    JPanel topPanel, controlPanel, bottomPanel, resultPanel;
    JLabel fromLabel, toLabel, initialLabel, finalLabel, valueLabel, resultLabel;
    JTextField fromNodeTextField, toNodeTextField, sourceTextField, destinationTextField, costTextField;
    JButton setPath, calculate, begin, result, reset;

    public GUI() throws IOException {

        setLayout(new BorderLayout());
        Font textFont = new Font("Poppins", Font.BOLD, 18);
        BufferedImage image = ImageIO.read(new File("src/main/java/gui/img_1.png"));
        JLabel picLabel = new JLabel(new ImageIcon(image));
        try {
            Image icon = ImageIO.read(new File("src/main/java/gui/icon.png"));
            ImageIcon ico = new ImageIcon(icon);
            setIconImage(ico.getImage());
        } catch (Exception e) {
            e.printStackTrace();
        }


        topPanel = new JPanel(new GridLayout(0, 1), true);

        topPanel.add(picLabel);
        resultLabel = new JLabel("RESULTS?", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Poppins", Font.PLAIN, 0));
        resultLabel.setForeground(Color.BLACK);

        resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());

        resultPanel.setPreferredSize(new Dimension(0, 0));
        resultPanel.setBackground(new Color(50, 50, 50));
        resultPanel.add(resultLabel, BorderLayout.CENTER);

        fromNodeTextField = new JTextField("Select a node");
        fromNodeTextField.setFont(textFont);
        fromNodeTextField.setHorizontalAlignment(SwingConstants.CENTER);
        fromNodeTextField.setPreferredSize(new Dimension(0, 20));

        toNodeTextField = new JTextField("Select a node");
        toNodeTextField.setFont(textFont);
        toNodeTextField.setHorizontalAlignment(SwingConstants.CENTER);
        toNodeTextField.setPreferredSize(new Dimension(0, 20));

        sourceTextField = new JTextField("Select the origin");
        sourceTextField.setFont(textFont);
        sourceTextField.setHorizontalAlignment(SwingConstants.CENTER);
        sourceTextField.setPreferredSize(new Dimension(0, 20));

        destinationTextField = new JTextField("Select the destination");
        destinationTextField.setFont(textFont);
        destinationTextField.setHorizontalAlignment(SwingConstants.CENTER);
        destinationTextField.setPreferredSize(new Dimension(0, 20));

        costTextField = new JTextField("Route cost");
        costTextField.setFont(textFont);
        costTextField.setHorizontalAlignment(SwingConstants.CENTER);
        costTextField.setPreferredSize(new Dimension(0, 20));

        fromLabel = new JLabel("Connect Node from", SwingConstants.LEFT);
        fromLabel.setFont(textFont);
        fromLabel.setForeground(Color.WHITE);

        toLabel = new JLabel("Connect Node to", SwingConstants.LEFT);
        toLabel.setFont(textFont);
        toLabel.setForeground(Color.WHITE);

        valueLabel = new JLabel("Cost to get", SwingConstants.LEFT);
        valueLabel.setFont(textFont);
        valueLabel.setForeground(Color.WHITE);

        initialLabel = new JLabel("Start From", SwingConstants.LEFT);
        initialLabel.setFont(textFont);
        initialLabel.setForeground(Color.WHITE);

        finalLabel = new JLabel("End to", SwingConstants.LEFT);
        finalLabel.setFont(textFont);
        finalLabel.setForeground(Color.WHITE);

        setPath = new JButton("Set Distance");
        setPath.setFont(new Font("Poppins", Font.BOLD, 20));
        setPath.setForeground(Color.WHITE);
        setPath.setForeground(Color.WHITE);
        setPath.setBackground(new Color(50, 50, 50));


        calculate = new JButton("Calculate");
        calculate.setFont(new Font("Poppins", Font.BOLD, 20));
        calculate.setForeground(Color.WHITE);
        calculate.setBackground(new Color(50, 50, 50));

        begin = new JButton("Begin!");
        begin.setFont(new Font("Poppins", Font.BOLD, 20));
        begin.setPreferredSize(new Dimension(0, 50));
        begin.setForeground(Color.WHITE);
        begin.setBackground(Color.decode("#3e8948"));

        reset = new JButton("Reset");
        reset.setFont(new Font("Poppins", Font.BOLD, 20));
        reset.setForeground(Color.WHITE);
        reset.setBackground(new Color(50, 50, 50));

        result = new JButton("Results");
        result.setFont(new Font("Poppins", Font.BOLD, 20));
        result.setForeground(Color.WHITE);
        result.setBackground(new Color(50, 50, 50));

        fromNodeTextField.setEnabled(false);
        toNodeTextField.setEnabled(false);
        costTextField.setEnabled(false);
        sourceTextField.setEnabled(false);
        destinationTextField.setEnabled(false);

        controlPanel = new JPanel();
        controlPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        controlPanel.setBackground(new Color(50, 50, 50));
        controlPanel.setLayout(new GridLayout(0, 1));

        controlPanel.add(begin);
        controlPanel.add(fromLabel);
        controlPanel.add(fromNodeTextField);
        controlPanel.add(toLabel);
        controlPanel.add(toNodeTextField);
        controlPanel.add(valueLabel);
        controlPanel.add(costTextField);
        controlPanel.add(setPath);

        controlPanel.add(initialLabel);
        controlPanel.add(sourceTextField);
        controlPanel.add(finalLabel);
        controlPanel.add(destinationTextField);
        controlPanel.add(calculate);
        controlPanel.add(result);
        controlPanel.add(reset);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(controlPanel, BorderLayout.CENTER);
        bottomPanel.add(resultPanel, BorderLayout.SOUTH);
        bottomPanel.setPreferredSize(new Dimension(250, MAXIMIZED_BOTH));
        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.WEST);
        System.out.println(topPanel.getSize());


        // Begin Logic
        begin.addActionListener(e -> {
            graph = new int[count][count];
            fromNodeTextField.setText("");
            toNodeTextField.setText("");
            costTextField.setText("");
            sourceTextField.setText("");
            destinationTextField.setText("");
            fromNodeTextField.requestFocus();
            fromNodeTextField.setEnabled(true);
            toNodeTextField.setEnabled(true);
            costTextField.setEnabled(true);
            setPath.setEnabled(true);
            sourceTextField.setEnabled(true);
            destinationTextField.setEnabled(true);
            calculate.setEnabled(true);
        });

        // Ease of use for text-field
        fromNodeTextField.addActionListener(text -> toNodeTextField.requestFocus());

        // Ease of use for text-field
        toNodeTextField.addActionListener(text -> costTextField.requestFocus());

        // Ease of use for text-field
        costTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent text) {
                setPath.doClick();
                fromNodeTextField.requestFocus();
                fromNodeTextField.setText("");
                toNodeTextField.setText("");
                costTextField.setText("");
            }
        });

        //Draws line between two given point
        setPath.addActionListener(ee -> {
            try {
                int fromInt = Integer.parseInt(fromNodeTextField.getText());
                int toInt = Integer.parseInt(toNodeTextField.getText());
                int value = Integer.parseInt(costTextField.getText());

                // Basic validation like negatives, No existing node etc.
                if (fromInt > count - 1 || toInt > count - 1 || value < 0 || fromInt < 0 || toInt < 0) {
                    JOptionPane.showMessageDialog(null, "Invalid Input", " Error", JOptionPane.ERROR_MESSAGE);
                    return;
                    // from == true then display err
                } else if (fromInt == toInt) {
                    JOptionPane.showMessageDialog(null, "Invalid Input", " Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                drawLine(fromInt, toInt, value);
                fromNodeTextField.requestFocus();
                fromNodeTextField.setText("");
                toNodeTextField.setText("");
                costTextField.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Input", " Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Ease of use for text-field
        sourceTextField.addActionListener(text -> destinationTextField.requestFocus());

        // Ease of use for text-field
        destinationTextField.addActionListener(text -> calculate.doClick());

        // the data is calculated here DIJKSTRA
        calculate.addActionListener(event -> {

            try {
                int source = Integer.parseInt(sourceTextField.getText());
                int destination = Integer.parseInt(destinationTextField.getText());

                // check for invalid input. Source and Destination > 0 or MAX
                if (source > count - 1 || destination > count - 1 || source < 0 || destination < 0) {
                    JOptionPane.showMessageDialog(null, "Invalid Input", " Error", JOptionPane.ERROR_MESSAGE);
                    sourceTextField.setText("");
                    destinationTextField.setText("");
                    sourceTextField.requestFocus();
                    return;
                }

                sourceTextField.setText("");
                destinationTextField.setText("");

                // get result
                algorithm.Dijkstra(graph, source, destination);

                // no path between given points?
                if (algorithm.distance == Integer.MAX_VALUE)
                    resultLabel.setText("No route for " + source + " -> " + destination);
                else { // show Optimal route
                    distance = algorithm.distance;
                    route = algorithm.stringPath;
                    resultLabel.setText("Optimal route for " + source + " -> " + destination + " is " + distance + " from route " + route);
                    showColor(algorithm.path, source);
                }
                fromNodeTextField.setEnabled(false);
                toNodeTextField.setEnabled(false);
                costTextField.setEnabled(false);
                sourceTextField.setEnabled(false);
                destinationTextField.setEnabled(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Input", " Error", JOptionPane.ERROR_MESSAGE);
                sourceTextField.setText("");
                destinationTextField.setText("");
                sourceTextField.requestFocus();
            }

        });

        // Click and add points
        topPanel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (begin.isEnabled()) {
                    int flag = 0;

                    // get the clicked coordinates
                    int x = e.getX() - 6;
                    int y = e.getY() + 15;
                    x_pos.add(x + 2);
                    y_pos.add(y + 40);

                    // no overlap for nodes >:)
                    for (int w = 0; w < x_pos.size() - 1; w++) {
                        if (x + 2 == x_pos.get(w) && y + 40 == y_pos.get(w)) {
                            JOptionPane.showMessageDialog(null, "Node Already present here", "Error", JOptionPane.ERROR_MESSAGE);
                            x_pos.remove(x_pos.size() - 1);
                            y_pos.remove(y_pos.size() - 1);
                            flag = 1;
                            return;
                        }
                    }
                    if (flag == 0)
                        drawNode(count++, x, y);
                }
            }

            // Unused overrides
            @Override
            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });

        // reset button handler
        reset.addActionListener(e -> {
            count = 0;
            graph = new int[0][0];
            x_pos.clear();
            y_pos.clear();
            begin.setEnabled(true);

            fromNodeTextField.setEnabled(false);
            toNodeTextField.setEnabled(false);
            costTextField.setEnabled(false);
            sourceTextField.setEnabled(false);
            destinationTextField.setEnabled(false);
            fromNodeTextField.setText("Select a node");
            toNodeTextField.setText("Select a node");
            costTextField.setText("Route cost");
            sourceTextField.setText("Select the origin");
            destinationTextField.setText("Select the destination");
            resultLabel.setText("Result?");
            algorithm.reset();
            repaint();
        });

        // button handler for result
        result.addActionListener(e -> JOptionPane.showMessageDialog(this, resultLabel, "Results", JOptionPane.INFORMATION_MESSAGE));
    }

    // changes path color to green if found
    private void showColor(ArrayList<Integer> path, int source) {
        drawLineChangeColor(source, path.get(0));
        drawNode(source, x_pos.get(source) - 2, y_pos.get(source) - 41);
        int i;
        for (i = 0; i < path.size() - 1; i++) {
            drawLineChangeColor(path.get(i), path.get(i + 1));
            drawNode(path.get(i), x_pos.get(path.get(i)) - 2, y_pos.get(path.get(i)) - 41);
        }
        drawNode(path.get(i), x_pos.get(path.get(i)) - 2, y_pos.get(path.get(i)) - 41);


    }

    // Draw the node visually in the space
    private void drawNode(int count, int x, int y) {
        Graphics g = this.getGraphics();
        Graphics2D graphics2d = (Graphics2D) g;
        g.setColor(Color.decode("#e43b44"));
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.fillOval(x + 250, y, 30, 30);
        Font font = new Font("Poppins", Font.BOLD, 22);
        g.setFont(font);
        g.setColor(Color.WHITE);
        String text = count + "";
        if (count > 9)
            g.drawString(text, x + 230, y + 20);
        else
            g.drawString(text, x + 258, y + 24);
    }

    // Draws line between two nodes
    private void drawLine(int from, int to, int value) {
        if (graph[from][to] != 0) {
            JOptionPane.showMessageDialog(null, "Can't Overwrite", " Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        graph[from][to] = value;
        Graphics g = this.getGraphics();
        Graphics2D graphics2d = (Graphics2D) g;
        g.setColor(new Color(228, 59, 68));
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.drawLine(x_pos.get(from) + 265, y_pos.get(from) - 25, x_pos.get(to) + 265, y_pos.get(to) - 25);

        String st = value + "";
        int x = (((x_pos.get(from) + x_pos.get(to)) / 2) + (x_pos.get(to))) / 2;
        int y = (((y_pos.get(from) + y_pos.get(to)) / 2) + (y_pos.get(to))) / 2;
        Font font = new Font("Poppins", Font.BOLD, 20);
        g.fillRect(x + 240, y - 36, 40, 20);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(st, x + 250, y - 20);
        drawNode(from, x_pos.get(from) - 2, y_pos.get(from) - 41);
        drawNode(to, x_pos.get(to) - 2, y_pos.get(to) - 41);

    }

    // Re-draw the lines which has now green color
    private void drawLineChangeColor(int from, int to) {
        Graphics g = this.getGraphics();
        Graphics2D graphics2d = (Graphics2D) g;
        g.setColor(new Color(97, 255, 97));
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.drawLine(x_pos.get(from) + 265, y_pos.get(from) - 25, x_pos.get(to) + 265, y_pos.get(to) - 25);
    }

    // java.Main Method

}

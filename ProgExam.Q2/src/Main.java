import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends JFrame {

    //declaring all components that will be displayed to the user
    private JTextField SalesYear1Field;
    private JTextField SalesYear2Field;

    private JTextArea OutputArea;

    //declaring the buttons
    private JButton LoadButton;
    private JButton SaveButton;

    //menu items
    private JMenuItem ExitMenuItem;
    private JMenuItem LoadMenuItem;
    private JMenuItem SaveMenuItem;
    private JMenuItem ClearMenuItem;

    //array to store product sales data
    private int[] productSales = new int[0];

    public Main() {

        setTitle("Product Sales Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));


        JPanel InputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        InputPanel.setBorder(BorderFactory.createTitledBorder("Enter Product Sales Data"));

        InputPanel.add(new JLabel("Sales for Year 1: "));
        SalesYear1Field = new JTextField();
        InputPanel.add(SalesYear1Field);

        InputPanel.add(new JLabel("Sales for Year 2: "));
        SalesYear2Field = new JTextField();
        InputPanel.add(SalesYear2Field);


        JPanel ButtonPanel = new JPanel(new FlowLayout());
        LoadButton = new JButton("Load Product Data");
        SaveButton = new JButton("Save Product Data");

        ButtonPanel.add(LoadButton);
        ButtonPanel.add(SaveButton);


        OutputArea = new JTextArea();
        OutputArea.setEditable(false);
        OutputArea.setBorder(BorderFactory.createTitledBorder("Output"));
        JScrollPane scrollPane = new JScrollPane(OutputArea);

        add(InputPanel, BorderLayout.NORTH);
        add(ButtonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);


        JMenuBar menuBar = new JMenuBar();
        JMenu FileMenu = new JMenu("File");
        JMenu ToolsMenu = new JMenu("Tools");

        ExitMenuItem = new JMenuItem("Exit");
        LoadMenuItem = new JMenuItem("Load Product Data");
        SaveMenuItem = new JMenuItem("Save Product Data");
        ClearMenuItem = new JMenuItem("Clear");

        FileMenu.add(ExitMenuItem);
        ToolsMenu.add(LoadMenuItem);
        ToolsMenu.add(SaveMenuItem);
        ToolsMenu.add(ClearMenuItem);

        menuBar.add(FileMenu);
        menuBar.add(ToolsMenu);

        setJMenuBar(menuBar);


        LoadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadProductData();
            }
        });

        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProductData();
            }
        });

        LoadMenuItem.addActionListener(e -> loadProductData());
        SaveMenuItem.addActionListener(e -> saveProductData());

        ClearMenuItem.addActionListener(e -> {
            OutputArea.setText("");
            SalesYear1Field.setText("");
            SalesYear2Field.setText("");
            productSales = new int[0];
        });

        ExitMenuItem.addActionListener(e -> System.exit(0));
    }


    private void loadProductData() {
        try {
            int sale1 = Integer.parseInt(SalesYear1Field.getText());
            int sale2 = Integer.parseInt(SalesYear2Field.getText());

            productSales = new int[]{sale1, sale2};

            ProductSales productsales = new ProductSales(productSales);

            OutputArea.setText(productsales.getReport());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please enter valid numeric values.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    private void saveProductData() {
        try {
            //here we are using write to file, what it does is it takes all the data inputed and calculated
            //and places it into a text file
            ProductSales ps = new ProductSales(productSales);

            PrintWriter writer = new PrintWriter(new FileWriter("data.txt"));
            writer.println(ps.getReport());
            writer.close();

            JOptionPane.showMessageDialog(null, "Data successfully saved.");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error saving data.",
                    "File Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
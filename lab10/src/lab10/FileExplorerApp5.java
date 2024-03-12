package lab10;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExplorerApp5 extends JFrame {
    private JTree directoryTree;
    private JTable fileInfoTable;
    private DefaultTableModel tableModel;
    private JTextField rowTextField;
    private JTextField columnTextField;

    public FileExplorerApp5() {
        super("File Explorer");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        directoryTree = new JTree();
        directoryTree.addTreeSelectionListener(e -> displayFileInfo());

        fileInfoTable = new JTable();
        tableModel = new DefaultTableModel(new Object[]{"Nume", "Dimensiune", "Ultima modificare", "Tip"}, 0);
        fileInfoTable.setModel(tableModel);

        rowTextField = new JTextField(5);
        columnTextField = new JTextField(5);

        ListSelectionModel rowSM = fileInfoTable.getSelectionModel();
        ListSelectionModel colSM = fileInfoTable.getColumnModel().getSelectionModel();

        rowSM.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    rowTextField.setText(String.valueOf(fileInfoTable.getSelectedRow() + 1));
                }
            }
        });

        colSM.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    columnTextField.setText(String.valueOf(fileInfoTable.getSelectedColumn() + 1));
                }
            }
        });

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(directoryTree), new JScrollPane(fileInfoTable));
        splitPane.setDividerLocation(200);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("Linia:"));
        bottomPanel.add(rowTextField);
        bottomPanel.add(new JLabel("Coloana:"));
        bottomPanel.add(columnTextField);

        add(splitPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        selectDirectory();
    }

    private void selectDirectory() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            buildTree(selectedDirectory);
        } else {
            System.exit(0);
        }
    }

    private void buildTree(File rootDirectory) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootDirectory);
        buildTreeRecursive(root, rootDirectory);
        directoryTree.setModel(new DefaultTreeModel(root));
    }

    private void buildTreeRecursive(DefaultMutableTreeNode node, File file) {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
                node.add(childNode);
                buildTreeRecursive(childNode, child);
            }
        }
    }

    private void displayFileInfo() {
        tableModel.setRowCount(0);

        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) directoryTree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            File selectedFile = (File) selectedNode.getUserObject();
            if (selectedFile.isDirectory()) {
                for (File file : selectedFile.listFiles()) {
                    Object[] rowData = {
                            file.getName(),
                            file.length(),
                            new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(file.lastModified())),
                            file.isDirectory() ? "Director" : "Fișier"
                    };
                    tableModel.addRow(rowData);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileExplorerApp5::new);
    }
}

package lab10;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExplorerApp extends JFrame {
    private JTree directoryTree;
    private JTable fileInfoTable;
    private DefaultTableModel tableModel;

    public FileExplorerApp() {
        super("File Explorer");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        directoryTree = new JTree();
        directoryTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                displayFileInfo();
            }
        });

        fileInfoTable = new JTable();
        tableModel = new DefaultTableModel(new Object[]{"Nume", "Dimensiune", "Ultima modificare", "Tip"}, 0);
        fileInfoTable.setModel(tableModel);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(directoryTree), new JScrollPane(fileInfoTable));
        splitPane.setDividerLocation(200);

        add(splitPane);

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
        tableModel.setRowCount(0); // Clear existing rows

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
        SwingUtilities.invokeLater(FileExplorerApp::new);
    }
}

package tabla;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.*;
public final class TablaProductos extends JFrame implements ActionListener{
    private JTextField numero,id,nombre,precio,numeroE,idE,nombreE,precioE,editarE;
    private JButton agregar,eliminar,editar;
    String datos[][]={
            {"1","Tacos","$12.00"},
            {"2","Tamales","$10.00"},
            {"3","Tortas","$35.00"},
            {"4","Cochitas","$45.00"}
        };
    String encabezado[]={"ID","Nombre","Precio"};
    DefaultTableModel model = new DefaultTableModel(datos,encabezado);
    JTable jt = new JTable(model);
    
    public TablaProductos(){
        super();
        configurarVentana();
        componentes();
    }
    
    private void configurarVentana(){
        this.setTitle("Tabla de productos");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void componentes(){
        agregar=new JButton();
        agregar.setText("Agregar");
        agregar.setBounds(0, 301, 100, 30);
        agregar.addActionListener(this);
        this.add(agregar);
        editar=new JButton();
        editar.setText("Editar");
        editar.setBounds(101, 301, 100, 30);
        editar.addActionListener(this);
        this.add(editar);
        eliminar=new JButton();
        eliminar.setText("Eliminar");
        eliminar.setBounds(202, 301, 100, 30);
        eliminar.addActionListener(this);
        this.add(eliminar);
        jt.setBounds(0, 0, 800, 300);
        this.add(jt);
        numero = new JTextField();
        numero.setBounds(202,331,100,20);
        this.add(numero);
        id = new JTextField();
        id.setBounds(0,331,100,20);
        this.add(id);
        nombre = new JTextField();
        nombre.setBounds(0,351,100,20);
        this.add(nombre);
        precio = new JTextField();
        precio.setBounds(0,371,100,20);
        this.add(precio);
        idE = new JTextField();
        idE.setBounds(101,331,100,20);
        this.add(idE);
        nombreE = new JTextField();
        nombreE.setBounds(101,351,100,20);
        this.add(nombreE);
        precioE = new JTextField();
        precioE.setBounds(101,371,100,20);
        this.add(precioE);
        editarE= new JTextField();
        editarE.setBounds(101, 391, 100, 20);
        this.add(editarE);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {;
                String id = numero.getText();
                int numEntero = Integer.parseInt(id);
                model.removeRow(numEntero-1);
            }
        });
        agregar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {;
                String id1 = id.getText();
                String nombre1 = nombre.getText();
                String precio1 = precio.getText();
                model.addRow(new Object[]{id1,nombre1,precio1});
            }
        });
        editar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {;
                String id1= idE.getText();
                String nombre1 = nombreE.getText();
                String precio1 = precioE.getText();
                String numEditar = editarE.getText();
                int numEntero = Integer.parseInt(numEditar);
                model.removeRow(numEntero);
                model.insertRow(numEntero,new Object[]{id1,nombre1,precio1});
                
            }
        });
    }
        

    public static void main(String[] args){
        TablaProductos ventana = new TablaProductos();
        ventana.setVisible(true);
    }
}

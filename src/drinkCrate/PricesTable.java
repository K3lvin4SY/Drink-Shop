package drinkCrate;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PricesTable extends JPanel {

	// Creating a table with the data and column names.
	public PricesTable() {
		String data[][]={ {"SUGAR","44 kr","-","38 kr","40 kr","35 kr","20 kr"},
                {"ZERO","47 kr","-","41 kr","43 kr","38 kr","23 kr"},
                {"ORANGE S","-","32 kr","-","-","-","-"},
                {"ORANGE Z","-","35 kr","-","-","-","-"},
                {"TROPICAL S","-","35 kr","-","-","-","-"},
                {"TROPICA Z","-","38 kr","-","-","-","-"},
                {"GRAPE S","-","42 kr","-","-","-","-"},
                {"GRAPE Z","-","45 kr","-","-","-","-"}
                };
		String column[]={"", "COLA","FANTA","PEPSI","SPRITE","7UP", "JARRITOS"};
		JTable jtable=new JTable(data,column);
		//jt.setBounds(30,40,200,300);
		JScrollPane scrollPane=new JScrollPane(jtable);
		add(scrollPane);
		setSize (new Dimension (775, 575));
		jtable.getColumnModel().getColumn(0).setWidth(2);
		jtable.getColumnModel().getColumn(1).setPreferredWidth(1);
		jtable.getColumnModel().getColumn(2).setPreferredWidth(1);
		jtable.getColumnModel().getColumn(3).setPreferredWidth(1);
		jtable.getColumnModel().getColumn(4).setPreferredWidth(1);
		jtable.getColumnModel().getColumn(5).setPreferredWidth(1);
		jtable.getColumnModel().getColumn(6).setPreferredWidth(1);
	}
}

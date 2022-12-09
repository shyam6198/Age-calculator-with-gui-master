import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat; 
import com.toedter.calendar.JDateChooser;
class Dategui implements ActionListener 
{
	Frame f;
	TextField tf,tf1;
	Button b;
	Label l,l1,l2,l3,l4,l5,l6,l7,l8;
	JDateChooser dateChooser;
	Dategui()
	{
		f=new Frame("Date Gui");
		b=new Button("Calculate");
		b.setBounds(230,160,70,40);
		b.addActionListener(this);
		dateChooser = new JDateChooser();
		dateChooser.setBounds(200,120,150,25);
		f.add(dateChooser);
		f.add(b);
		l=new Label("Age Calculator",l.CENTER);      
        l.setBounds(10,20,530,90);
		f.add(l);
		l.setBackground(Color.RED);
		l.setFont(new Font("Serif", Font.PLAIN, 36));
		l1=new Label("Enter the Date Of Birth");
		l1.setBounds(10,120,200,20);
        f.add(l1);
		l1.setFont(new Font("Serif", Font.PLAIN, 16));
		l2=new Label("e.g (DD/MM/YEAR)");
		l2.setBounds(10,135,200,20);
        f.add(l2);
		l2.setFont(new Font("Serif", Font.PLAIN, 10));
		l3=new Label("Current Date");
		l3.setBounds(10,200,530,20);
        f.add(l3);
		l3.setFont(new Font("Serif", Font.PLAIN, 15));
		l4=new Label();
		l4.setBounds(10,220,530,50);
        f.add(l4);
		l4.setFont(new Font("Serif", Font.PLAIN, 50));
		l5=new Label("Date Of Birth");
		l5.setBounds(10,270,530,20);
        f.add(l5);
		l5.setFont(new Font("Serif", Font.PLAIN, 15));
		l6=new Label();
		l6.setBounds(10,290,530,50);
        f.add(l6);
		l6.setFont(new Font("Serif", Font.PLAIN, 50));
		l7=new Label("Your Age is");
		l7.setBounds(10,340,530,20);
        f.add(l7);
		l7.setFont(new Font("Serif", Font.PLAIN, 15));
		l8=new Label();
		l8.setBounds(10,360,530,60);
        f.add(l8);
		l8.setFont(new Font("Serif", Font.PLAIN, 50));
		f.setLayout(null);
		f.setSize(550,450);
		f.setVisible(true);
		f.addWindowListener(new WindowEventListener());
	}
	public void actionPerformed(ActionEvent e)
	{
		SimpleDateFormat my= new SimpleDateFormat("dd/MM/yyyy");
		String s=my.format(dateChooser.getDate());
		System.out.println(s);
        if(s.isBlank())
		{
			l6.setText("Please enter the date");
		}
		else
		{
		l6.setText(s);
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        String formattedDate = myDateObj.format(myFormatObj);
		l4.setText(formattedDate.toString());
		String s1=Date.Age(s);
		l8.setText(s1);
		}
    }
	
	public static void main(String s[])
    {
       new Dategui();

    }
}
class WindowEventListener extends WindowAdapter
{
public void windowClosing(WindowEvent e1)
{
  System.exit(0);
}
}
class Date
{
	public static String Age(String d)
	{
		System.out.println(d);
		String[] a=d.split("/");
		int size = a.length;
        int [] arr = new int [size];
        for(int i=0; i<size; i++) {
         arr[i] = Integer.parseInt(a[i]);
        }
		LocalDate localDate = LocalDate.now();	
		LocalDate localDate1=localDate.minusDays(arr[0]);
		LocalDate localDate2=localDate1.minusMonths(arr[1]);
		LocalDate localDate3=localDate2.minusYears(arr[2]);
		String str= localDate3.toString();
		String[] str1=str.split("-");
		int size1 = str1.length;
        int [] arr1 = new int [size];
        for(int i=0; i<size1; i++) {
         arr1[i] = Integer.parseInt(str1[i]);
        }
		return (arr1[0]+ " Year " +arr1[1]+" Month "+ arr1[2] +" Days ");
	}
}
package math;

import java.awt.*;
import javax.swing.JWindow;
import java.applet.*;
import java.lang.Object;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JRootPane;

public class Login extends JFrame{
	private JFrame fr=null;
	
	private Button next=null;
	private JButton close=null;
	private Button nandu=null;
	private Label  formula;

	private Checkbox a_0;
	private JLabel jl1;
	private JLabel jl2;
	private JButton b_1;
	private Checkbox a_1;
	private JTextField jtf1;
	private JPasswordField jpf1;
	private Checkbox a_2;
	private Checkbox a_3;
	private CheckboxGroup zu;

	private Label b_ans0;
	private Label b_ans1;
	private Label b_ans2;
	private Label b_ans3;


	private CreateFormula cf;

	private Checkbox c_0;
	private Checkbox c_1;
	private Checkbox c_2;


	private Label d_ans0;
	private Label d_ans1;
	private Label d_ans2;

	private Label tongji0;
	private Label tongji1;
	private Label tongji2;

	int all=0,r=0,xx=0;


 


	Login()
	{
		init();
		setBounds();
		addComps();
		addListeners();
		refresh();
		this.getContentPane().add(new JLabel("Just a test."));
		this.setUndecorated(true); // ȥ�����ڵ�װ��
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);// ����ָ���Ĵ���װ�η��
		this.setSize(300, 150);
	}

	void init()//��ʼ��
	{
		fr=new JFrame("��ѧ���-By���&������");//����


		next=new Button("��һ��");
		nandu=new Button("ȷ��");
		
		formula=new Label("formula------");
		b_ans0=new Label("formula0");
		b_ans1=new Label("formula1");
		b_ans2=new Label("formula2");
		b_ans3=new Label("formula3");
		d_ans0=new Label("��");
		d_ans1=new Label("�е�");
		d_ans2=new Label("����");
		tongji0=new Label("     ����:  "+all+"��");
		tongji1=new Label("     ����:  "+r+"��");
		tongji2=new Label("     ����:  "+(all-r)+"��");
		jtf1 = new JTextField(10);

        jpf1 = new JPasswordField(10);// ���ò��ֹ���(�������ǣ�extends JFrame�����������)
        this.setLayout(new GridLayout(3, 1));

		zu=new CheckboxGroup();
		a_0=new Checkbox(null,false,zu);
		a_1=new Checkbox(null,false,zu);
		a_2=new Checkbox(null,false,zu);
		a_3=new Checkbox(null,false,zu);
		c_0=new Checkbox(null,false,zu);
		c_1=new Checkbox(null,false,zu);
		c_2=new Checkbox(null,false,zu);
		cf=new CreateFormula();
		jl1 = new JLabel(new ImageIcon(getClass().getResource("/math/1.png")));
		jl2 = new JLabel(new ImageIcon(getClass().getResource("/math/circle.gif")));
		b_1=new JButton(new ImageIcon(getClass().getResource("/math/2.png")));
		close=new JButton(new ImageIcon(getClass().getResource("/math/c.png")));
	}
	void addComps()//������������ǩ,��ť��ӵ�frame��
	{

		fr.add(next);
		fr.add(b_1);
		fr.add(close);
		fr.add(jtf1);
		fr.add(jpf1);
		fr.add(nandu);
		fr.add(formula);
		fr.add(a_0);
		fr.add(a_1);
		fr.add(a_2);
		fr.add(a_3);
		fr.add(b_ans0);
		fr.add(b_ans1);
		fr.add(b_ans2);
		fr.add(b_ans3);
		fr.add(c_0);
		fr.add(c_1);
		fr.add(jl2);
		fr.add(jl1);
		fr.add(c_2);
		fr.add(d_ans0);
		fr.add(d_ans1);
		fr.add(d_ans2);
		fr.add(tongji0);
		fr.add(tongji1);
		fr.add(tongji2);
		LoginListener ll = new LoginListener(fr,jtf1,jpf1);
		b_1.addActionListener(ll);


	}
	
	
	void setBounds()//
	{
		fr.setBounds(448,200,1024,768);
		
		close.setBounds(980,6,30,30);
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		fr.setUndecorated(true);
		b_1.setBounds(408,680,224,58);
		b_1.setBorderPainted(false);
		b_1.setContentAreaFilled(false);
		jl2.setBounds(0,-72,1024,768);
		jl1.setBounds(0,0,1024,768);
		
		jtf1.setBounds(240,618,224,35);
		jpf1.setBounds(565,618,224,35);
		fr.setLayout(null);
		fr.setVisible(true);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


	}
	
	 
	void setForeground()
	{
		next.setForeground(Color.blue);
	}
	void setBackground()
	{
		next.setBackground(Color.blue);
	}        
	void addListeners()//����¼�������
	{
		close.addActionListener(new ActionListener()//��һ��

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
					}
					});
		fr.addWindowListener(new WindowAdapter()
		{public void windowClosing(WindowEvent e){
			int c=st();
			if(c==JOptionPane.YES_OPTION)
				System.exit(0);//�˳�
		}
		});


		nandu.addActionListener(new ActionListener()//�����Ѷ�
		{      public void actionPerformed(ActionEvent e){

			if(c_0.getState()) xx=0;
			if(c_1.getState()) xx=1;
			if(c_2.getState()) xx=2;
			cf.tiaozhennandu(xx);
			refresh();
		}
		});


		next.addActionListener(new ActionListener()//��һ��

		{
			public void actionPerformed(ActionEvent e) {
				String rightMessage="��ϲ��!�����!";
				String wrongMessage="����~��ȷ��Ӧ����"+cf.getResult();
				//�ж��Ƿ����
				int c=-1;
				if(a_0.getState()) c=0;
				if(a_1.getState()) c=1;
				if(a_2.getState()) c=2;
				if(a_3.getState()) c=3;
				if(c==-1)
				{alert("��ѡ��","����û��ѡ��");
				}
				else
				{if(c==cf.getRight())
				{
					alert("��ȷ",rightMessage);
					r++;
				}
				else alert("����",wrongMessage);
					all++;
					refresh();
					tongji0.setText("     ����:  "+all+"��");
					tongji1.setText("     ����:  "+r+"��");
					tongji2.setText("     ����:  "+(all-r)+"��");
				}
			}
		});
	}


	void refresh()
	{
		cf.run();//����run����������Ŀ�ʹ�
		formula.setText((all+1)+".   "+cf.getFormula());
		b_ans0.setText("A     "+cf.getAnswers(0));
		b_ans1.setText("B     "+cf.getAnswers(1));
		b_ans2.setText("C     "+cf.getAnswers(2));
		b_ans3.setText("D     "+cf.getAnswers(3));
		zu.setSelectedCheckbox(null);
		a_0.setState(false);
		a_1.setState(false);
		a_2.setState(false);
		a_3.setState(false);
		if(xx==0) {d_ans0.setForeground(Color.red);d_ans1.setForeground(Color.black);d_ans2.setForeground(Color.black);}
		if(xx==1) {d_ans0.setForeground(Color.black);d_ans1.setForeground(Color.red);d_ans2.setForeground(Color.black);}
		if(xx==2) {d_ans0.setForeground(Color.black);d_ans1.setForeground(Color.black);d_ans2.setForeground(Color.red);}

	}

	void alert(String title,String message)//��ƴ��ڸ�ʽ
	{
		JOptionPane.showMessageDialog(
				fr,message,title,
				JOptionPane.INFORMATION_MESSAGE);
	}

	int st()
	{
		double s;
		String hint;
		if(all>0)//������Ӧ�÷ָ�����Ӧ���۲�ͳ����Ϣ
		{
			s=(double)r/all*100;
			s=(double)((int)(s*10+0.5))/10; //����һλС��
		}
		else
			s=-1;
		if(s==-1)
			hint="���������~";
		else if(s<60)
			hint="��ҪŬ��Ŷ~";
		else if(s<80)
			hint="������Ŷ~";
		else if(s<90)
			hint="��ĺܲ���Ŷ~";
		else hint="̫����~";
		String str="ͳ����Ϣ:\n���ܹ�����:  "+all+"\n������ȷ��:  "+r+"\n���ƴ�����:  "+(all-r)+"\n��ȷ��:  "+
				(all==0?"-":s+"%")+"\n"+hint+"\n\n�����Ҫ�˳���?";
		return JOptionPane.showConfirmDialog(fr,str,"ͳ����Ϣ",JOptionPane.YES_NO_OPTION);
	}





	public static void main(String[] args)  
	{   
	new Login();//����Login����
	}  
}

 



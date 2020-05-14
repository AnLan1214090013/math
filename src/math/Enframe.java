package math;

import java.awt.*;
import java.applet.*;
import java.lang.Object;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Enframe {
	private JFrame fr=null;
	private Button next=null;
	private JButton tong=null;
	private JButton nandu=null;
	private JLabel  formula;

	private Checkbox a_0;
	private JLabel jl1;
	private JButton ne;
	private JButton middle;
	private JButton xiao;
	private Checkbox a_1;
	private Checkbox a_2;
	private Checkbox a_3;
	private CheckboxGroup zu;

	private JLabel b_ans0;
	private JLabel b_ans1;
	private JLabel b_ans2;
	private JLabel b_ans3;


	private CreateFormula cf;

	private Checkbox c_0;
	private Checkbox c_1;
	private JButton close=null;
	private Checkbox c_2;


	private JLabel d_ans0;
	private JLabel d_ans1;
	private JLabel d_ans2;

	private JLabel tongji0;
	private JLabel tongji1;
	private JLabel tongji2;

	int all=0,r=0,xx=0;


	Enframe()
	{
		init();
		setBounds();
		addComps();
		addListeners();
		refresh();
	}

	void init()//��ʼ��
	{
		fr=new JFrame("��Сѧ��ϰ���");//����


		next=new Button("��һ��");
		formula=new JLabel("formula------");
		b_ans0=new JLabel("formula0");
		b_ans1=new JLabel("formula1");
		b_ans2=new JLabel("formula2");
		b_ans3=new JLabel("formula3");
		d_ans0=new JLabel("��");
		d_ans1=new JLabel("�е�");
		d_ans2=new JLabel("����");
		tongji0=new JLabel(""+all+"��");
		tongji1=new JLabel(""+r+"��");
		tongji2=new JLabel(""+(all-r)+"��");

		zu=new CheckboxGroup();
		a_0=new Checkbox(null,false,zu);
		a_1=new Checkbox(null,false,zu);
		a_2=new Checkbox(null,false,zu);
		a_3=new Checkbox(null,false,zu);
		c_0=new Checkbox(null,false,zu);
		c_1=new Checkbox(null,false,zu);
		c_2=new Checkbox(null,false,zu);
		cf=new CreateFormula();
		jl1 = new JLabel(new ImageIcon(getClass().getResource("/math/enb.png")));
		close=new JButton(new ImageIcon(getClass().getResource("/math/c.png")));
		ne=new JButton(new ImageIcon(getClass().getResource("/math/ne.png")));
		tong=new JButton(new ImageIcon(getClass().getResource("/math/tong.png")));
		nandu=new JButton(new ImageIcon(getClass().getResource("/math/queren.png")));
		xiao=new JButton(new ImageIcon(getClass().getResource("/math/xiao.png")));
		middle=new JButton(new ImageIcon(getClass().getResource("/math/middle.png")));
	}
	void addComps()//������������ǩ,��ť��ӵ�frame��
	{

		fr.add(next);
		fr.add(close);
		fr.add(ne);
		fr.add(tong);
		fr.add(nandu);
		fr.add(formula);
		fr.add(a_0);
		fr.add(a_1);
		fr.add(xiao);
		fr.add(middle);
		fr.add(a_2);
		fr.add(a_3);
		fr.add(b_ans0);
		fr.add(b_ans1);
		fr.add(b_ans2);
		fr.add(b_ans3);
		fr.add(c_0);
		fr.add(c_1);
		fr.add(c_2);
		fr.add(d_ans0);
		fr.add(d_ans1);
		fr.add(d_ans2);
		fr.add(tongji0);
		fr.add(tongji1);
		fr.add(tongji2);
		fr.add(jl1);


	}
	void setBounds()//
	{
		fr.setBounds(448,140,1024,768);
		fr.getContentPane().setBackground( Color.WHITE );
		jl1.setBounds(0,0,1024,768);
		fr.setUndecorated(true);
		nandu.setBounds(600,190,200,70);
		nandu.setBorderPainted(false);
		nandu.setContentAreaFilled(false);

		ne.setBounds(350,650,200,70);
		ne.setBorderPainted(false);
		ne.setContentAreaFilled(false);
		tong.setBounds(5,710,50,50);
		tong.setBorderPainted(false);
		tong.setContentAreaFilled(false);
		close.setBounds(980,6,30,30);
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		formula.setBounds(390,300,150,50);
		b_ans0.setBounds(230,370,100,50);
		b_ans1.setBounds(570,370,100,50);
		b_ans2.setBounds(230,520,100,50);
		b_ans3.setBounds(570,520,100,50);
		a_0.setBounds(210,385,20,20);
		a_1.setBounds(550,385,20,20);
		a_2.setBounds(210,535,20,20);
		a_3.setBounds(550,535,20,20);
		c_0.setBounds(160,240,20,20);
		c_1.setBounds(320,240,20,20);
		c_2.setBounds(480,240,20,20);
		d_ans0.setFont(new java.awt.Font("΢���ź�",10,30));
		d_ans1.setFont(new java.awt.Font("΢���ź�",10,30));
		d_ans2.setFont(new java.awt.Font("΢���ź�",10,30));
		d_ans0.setBounds(140,200,60,30);
		d_ans1.setBounds(300,200,60,30);
		d_ans2.setBounds(460,200,60,30);
		tongji0.setBounds(880,160,150,60);
		tongji1.setBounds(880,418,150,60);
		tongji2.setBounds(880,686,150,60);
		tongji0.setOpaque(false);
		fr.setLayout(null);
		fr.setVisible(true);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		tongji0.setFont(new java.awt.Font("΢���ź�",10,20));
		tongji0.setForeground(Color.white);
		tongji1.setFont(new java.awt.Font("΢���ź�",10,20));
		tongji1.setForeground(Color.white);
		tongji2.setFont(new java.awt.Font("΢���ź�",10,20));
		tongji2.setForeground(Color.white);
		b_ans0.setFont(new java.awt.Font("Dialog",1,24));
		b_ans1.setFont(new java.awt.Font("Dialog",1,24));
		b_ans2.setFont(new java.awt.Font("Dialog",1,24));
		b_ans3.setFont(new java.awt.Font("Dialog",1,24));
		formula.setFont(new java.awt.Font("Dialog",1,24));		
		xiao.setBounds(6,55,48,48);
		xiao.setBorderPainted(false);
		xiao.setContentAreaFilled(false);
		middle.setBounds(6,115,48,48);
		middle.setBorderPainted(false);
		middle.setContentAreaFilled(false);
		
		

	}

	void addListeners()//����¼�������
	{
		close.addActionListener(new ActionListener()//��һ��

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
						
						
					}
					});
		middle.addActionListener(new ActionListener()//��һ��

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
						new Mathframe();
						
					}
					});
		xiao.addActionListener(new ActionListener()//��һ��

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
						new TestFrame();
						
						
					}
					});
		tong.addActionListener(new ActionListener()//��һ��

				{
					public void actionPerformed(ActionEvent e) {
						int c=st();
						
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


		ne.addActionListener(new ActionListener()//��һ��

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
					tongji0.setText(""+all+"��");
					tongji1.setText(""+r+"��");
					tongji2.setText(""+(all-r)+"��");
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
				(all==0?"-":s+"%")+"\n"+hint;
		return JOptionPane.showConfirmDialog(fr,str,"ͳ����Ϣ",JOptionPane.YES_OPTION);
	}





	public static void main(String[] args)
	{
		new TestFrame();//����TestFrame����


	}
}

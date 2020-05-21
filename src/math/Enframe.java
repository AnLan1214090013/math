package math;

import java.awt.*;
import java.applet.*;
import java.lang.Object;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;


public class Enframe {
	Jdbcs_1 timu = new Jdbcs_1();
	private JFrame fr=null;
	private Button next=null;
	private JButton tong=null;
	private JButton nandu=null;
	private JLabel  e1;
	private JLabel  e2;
	private JLabel  e3;
	private JLabel  e4;
	private JTextField a1;
	private JTextField a2;
	private JTextField a3;
	private JTextField a4;
	private JLabel jl1;
	private JButton ne;
	private JButton chou;
	private JButton middle;
	private JButton xiao;
	private CheckboxGroup zu;

	private JLabel b_ans0;
	private JLabel b_ans1;
	private JLabel b_ans2;
	private JLabel b_ans3;


	private CreateFormula cf;

	private JButton close=null;


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
	}

	void init()
	{
		fr=new JFrame("��Сѧ��ϰ���");


		next=new Button("��һ��");
		e1=new JLabel("���ʵȴ���ȡ",JLabel.CENTER);
		e2=new JLabel("2.���ʵȴ���ȡ");
		e3=new JLabel("3.���ʵȴ���ȡ");
		e4=new JLabel("4.���ʵȴ���ȡ");
		tongji0=new JLabel(""+all+"��");
		tongji1=new JLabel(""+r+"��");
		tongji2=new JLabel(""+(all-r)+"��");
		a1 = new JTextField(20);
		a2 = new JTextField(20);
		a3 = new JTextField(20);
		a4 = new JTextField(20);
		zu=new CheckboxGroup();

		cf=new CreateFormula();
		jl1 = new JLabel(new ImageIcon(getClass().getResource("/math/enb.png")));
		close=new JButton(new ImageIcon(getClass().getResource("/math/c.png")));
		chou=new JButton(new ImageIcon(getClass().getResource("/math/chou.png")));
		tong=new JButton(new ImageIcon(getClass().getResource("/math/tong.png")));
		nandu=new JButton(new ImageIcon(getClass().getResource("/math/pigai.png")));
		xiao=new JButton(new ImageIcon(getClass().getResource("/math/xiao.png")));
		middle=new JButton(new ImageIcon(getClass().getResource("/math/middle.png")));
	}
	void addComps()
	{

		fr.add(next);
		fr.add(close);
		fr.add(chou);
		fr.add(tong);
		fr.add(nandu);
		fr.add(a1);
		fr.add(a2);
		fr.add(a3);
		fr.add(a4);
		fr.add(e1);
		fr.add(e2);
		fr.add(e3);
		fr.add(e4);
		fr.add(xiao);
		fr.add(middle);
		fr.add(tongji0);
		fr.add(tongji1);
		fr.add(tongji2);
		fr.add(jl1);


	}
	void setBounds()
	{
		fr.setBounds(448,140,1024,768);
		fr.getContentPane().setBackground( Color.WHITE );
		jl1.setBounds(0,0,1024,768);
		fr.setUndecorated(true);
		nandu.setBounds(550,650,200,70);
		nandu.setBorderPainted(false);
		nandu.setContentAreaFilled(false);

		chou.setBounds(150,650,200,70);
		chou.setBorderPainted(false);
		chou.setContentAreaFilled(false);
		tong.setBounds(5,710,50,50);
		tong.setBorderPainted(false);
		tong.setContentAreaFilled(false);
		close.setBounds(980,6,30,30);
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		e1.setBounds(220,200,450,100);
		e1.setFont(new java.awt.Font("΢���ź�",30,60));
		a1.setBounds(390,360,140,40);
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
				
		xiao.setBounds(6,55,48,48);
		xiao.setBorderPainted(false);
		xiao.setContentAreaFilled(false);
		middle.setBounds(6,115,48,48);
		middle.setBorderPainted(false);
		middle.setContentAreaFilled(false);
		
		

	}

	void addListeners()
	{
		close.addActionListener(new ActionListener()

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
						
						
					}
					});
		chou.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent e) {
				
		        int id = (int)(1+Math.random()*(10-1+1));
                final Jdbcs_1 timu1 = timu.chou(id);
                e1.setText(timu1.getEN());
			}
			});
		nandu.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent e) {
				all++;
				tongji0.setText(""+all+"��");
				tongji2.setText(""+(all-r)+"��");
				
				Jdbcs_1 d = new Jdbcs_1();
				String answer = a1.getText();
				String en = e1.getText();
		        if (d.compare(answer, en)) 
					
				{	
		        	JOptionPane.showMessageDialog(null, "����ȷ��");
		        	r++;
		        	tongji1.setText(""+r+"��");
		        	
				}
			}
			});
		middle.addActionListener(new ActionListener()

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
						new Mathframe();
						
					}
					});
		xiao.addActionListener(new ActionListener()

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
						new TestFrame();
						
						
					}
					});
		tong.addActionListener(new ActionListener()

				{
					public void actionPerformed(ActionEvent e) {
						int c=st();
						
					}
					});
		fr.addWindowListener(new WindowAdapter()
		{public void windowClosing(WindowEvent e){
			int c=st();
			if(c==JOptionPane.YES_OPTION)
				System.exit(0);
		}
		});



fr.addWindowListener(new WindowAdapter()
{public void windowClosing(WindowEvent e){
	int c=st();
	if(c==JOptionPane.YES_OPTION)
		System.exit(0);
}
});




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

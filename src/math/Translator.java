package math;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Translator  extends JFrame
{
	private JButton button1;
	private JButton button2;
	private JTextField text;
	private JTextArea textshow;
	private Map<String , String> map;		//���ʺ�������˼ ��ӳ��
	private Dimension Dim;					//��װ���ڴ�С
	
	public void init()
	{
		//ʵ����������ݳ�Ա
		this.Dim = new Dimension(this.getWidth() , this.getHeight());
		this.button1 = new JButton("Ӣ�뺺");
		this.button2 = new JButton("����Ӣ");
		this.text = new JTextField();
		this.textshow = new JTextArea();
		
		//�ϲ��������
		JPanel nor_pan = new JPanel();
		ImageIcon  image = new ImageIcon("src\\cn\\com\\1492060892.jpg");
		JLabel Limage = new JLabel(image);
		Limage.setPreferredSize(new Dimension(this.Dim.width, this.Dim.height/2));
		nor_pan.add(Limage);		//��ͼƬ��ǩ��ӵ������
		this.add(nor_pan , BorderLayout.NORTH);	//�ϲ����nor_pan��ӵ�������
		
		//�в��������
		JPanel cen_pan = new JPanel();
		JLabel Ltext = new JLabel("������Ҫ��ѯ�����ݣ�");
		Ltext.setFont(new Font("����",Font.BOLD,20));
		cen_pan.add(Ltext);								//��������ϣ�������
		this.text.setPreferredSize(new Dimension(400 , 30));
		this.text.setHorizontalAlignment(this.text.CENTER);	//���þ�������
		cen_pan.add(this.text);		//�ı�����ӵ����
		this.textshow.setPreferredSize(new Dimension(600 , 150));
		cen_pan.add(this.textshow);
		this.add(cen_pan , BorderLayout.CENTER);			//�м����cen_pan��ӵ�������
		
		
		//�ײ��������
		FlowLayout flowlayout = new FlowLayout();
		flowlayout.setHgap(80); 	//���֮������80��ˮƽ���
		JPanel sou_pan = new JPanel();
		sou_pan.setLayout(flowlayout);
		this.button1.setPreferredSize(new Dimension(100,30));
		this.button2.setPreferredSize(new Dimension(100,30));
		sou_pan.add(this.button1);
		sou_pan.add(this.button2);
		this.add(sou_pan , BorderLayout.SOUTH);
		
		//ע�������
		this.button1.addActionListener(new myActionEvent(1));
		this.button2.addActionListener(new myActionEvent(2));
		this.addWindowListener(new WindowHandler());
		
		
		//������������
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�ҵĵ��ʲ�����");
		this.setVisible(true);
		
	}
	
	//���ڼ������ʵ����
	private class WindowHandler extends WindowAdapter
	{
		//���ڼ���ʱ��Ӵ�������
		public void windowActivated(WindowEvent e)
		{
			Translator.this.map = new HashMap<String , String>();
			Translator.this.map.put("apple" , "ƻ��");
			Translator.this.map.put("pear" , "��");
			Translator.this.map.put("pig" , "��");
			Translator.this.map.put("animal" , "����");
			Translator.this.map.put("book" , "�鱾");		
		}

		
	}
	
	//��ť�¼�����ʵ����
	private class myActionEvent implements ActionListener
	{
		private int Statue;		//״̬����
		//�����Ǻ���Ӣ����Ӣ�뺺
		public myActionEvent(int Statue)
		{
			this.Statue = Statue;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			String str = Translator.this.text.getText();	//��ȡ�û��������ı�
			
			//�����û�����Ϊ��
			if (str==null || str.isEmpty())
			{
				JOptionPane.showMessageDialog(Translator.this, "������Ҫ��ѯ�ĵ���" , null , JOptionPane.WARNING_MESSAGE);
				return ;
			}
				
			//��ʼ���ҵ���
			if (this.Statue==1)
			{
				String meaning1 = Translator.this.map.get(str);
				if (meaning1 == null)
				{
					JOptionPane.showMessageDialog(Translator.this, "û�в鵽������ĵ���" , null , JOptionPane.WARNING_MESSAGE);
					return;
				}
					
				else
					Translator.this.textshow.setText(meaning1);
			}
			else if(this.Statue==2)
			{
				String meaning2 =getKeyByValue(Translator.this.map , str);
				if (meaning2 == " ")
				{
					JOptionPane.showMessageDialog(Translator.this, "û�в鵽������ĵ���" , null , JOptionPane.WARNING_MESSAGE);
					return;
				}
					
				else
					Translator.this.textshow.setText((String) meaning2);
			}
			
		}	
		
		// ͨ��map��value�õ�key
	    public  String getKeyByValue(Map map, Object value) 
	    {
	        // ���ȵõ�entrySet�ĵ�����it
	        Iterator it =  map.entrySet().iterator();
	        Map.Entry entry = null;
	        boolean match = false;
	        while (it.hasNext()) 
	        {
	            entry = (Map.Entry) it.next();
	            Object obj = entry.getValue();
	            if (value.equals(obj)) 
	            {
	            	match = true;
	            	break;
	            }
	        }
	        if (match == true)
	        	return (String) entry.getKey();
	        else
	        	return " ";
	    }
		
	}
	

	
	public Translator()
	{
		this.setSize(700, 500);
		init();
	}
	
	
	

}
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
	private Map<String , String> map;		//单词和中文意思 的映射
	private Dimension Dim;					//封装窗口大小
	
	public void init()
	{
		//实例化类的数据成员
		this.Dim = new Dimension(this.getWidth() , this.getHeight());
		this.button1 = new JButton("英译汉");
		this.button2 = new JButton("汉译英");
		this.text = new JTextField();
		this.textshow = new JTextArea();
		
		//上部面板制作
		JPanel nor_pan = new JPanel();
		ImageIcon  image = new ImageIcon("src\\cn\\com\\1492060892.jpg");
		JLabel Limage = new JLabel(image);
		Limage.setPreferredSize(new Dimension(this.Dim.width, this.Dim.height/2));
		nor_pan.add(Limage);		//将图片标签添加到面板上
		this.add(nor_pan , BorderLayout.NORTH);	//上部面板nor_pan添加到容器上
		
		//中部面板制作
		JPanel cen_pan = new JPanel();
		JLabel Ltext = new JLabel("请输入要查询的内容：");
		Ltext.setFont(new Font("楷体",Font.BOLD,20));
		cen_pan.add(Ltext);								//加在面板上！！！！
		this.text.setPreferredSize(new Dimension(400 , 30));
		this.text.setHorizontalAlignment(this.text.CENTER);	//设置居中输入
		cen_pan.add(this.text);		//文本框添加到面板
		this.textshow.setPreferredSize(new Dimension(600 , 150));
		cen_pan.add(this.textshow);
		this.add(cen_pan , BorderLayout.CENTER);			//中间面板cen_pan添加到容器上
		
		
		//底部面板制作
		FlowLayout flowlayout = new FlowLayout();
		flowlayout.setHgap(80); 	//组件之间设置80的水平间隔
		JPanel sou_pan = new JPanel();
		sou_pan.setLayout(flowlayout);
		this.button1.setPreferredSize(new Dimension(100,30));
		this.button2.setPreferredSize(new Dimension(100,30));
		sou_pan.add(this.button1);
		sou_pan.add(this.button2);
		this.add(sou_pan , BorderLayout.SOUTH);
		
		//注册监视器
		this.button1.addActionListener(new myActionEvent(1));
		this.button2.addActionListener(new myActionEvent(2));
		this.addWindowListener(new WindowHandler());
		
		
		//窗口属性设置
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("我的单词查阅器");
		this.setVisible(true);
		
	}
	
	//窗口激活监听实例类
	private class WindowHandler extends WindowAdapter
	{
		//窗口激活时添加储备单词
		public void windowActivated(WindowEvent e)
		{
			Translator.this.map = new HashMap<String , String>();
			Translator.this.map.put("apple" , "苹果");
			Translator.this.map.put("pear" , "梨");
			Translator.this.map.put("pig" , "猪");
			Translator.this.map.put("animal" , "动物");
			Translator.this.map.put("book" , "书本");		
		}

		
	}
	
	//按钮事件监听实例类
	private class myActionEvent implements ActionListener
	{
		private int Statue;		//状态参数
		//设置是汉译英还是英译汉
		public myActionEvent(int Statue)
		{
			this.Statue = Statue;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			String str = Translator.this.text.getText();	//获取用户的输入文本
			
			//若果用户输入为空
			if (str==null || str.isEmpty())
			{
				JOptionPane.showMessageDialog(Translator.this, "请输入要查询的单词" , null , JOptionPane.WARNING_MESSAGE);
				return ;
			}
				
			//开始查找单词
			if (this.Statue==1)
			{
				String meaning1 = Translator.this.map.get(str);
				if (meaning1 == null)
				{
					JOptionPane.showMessageDialog(Translator.this, "没有查到您输入的单词" , null , JOptionPane.WARNING_MESSAGE);
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
					JOptionPane.showMessageDialog(Translator.this, "没有查到您输入的单词" , null , JOptionPane.WARNING_MESSAGE);
					return;
				}
					
				else
					Translator.this.textshow.setText((String) meaning2);
			}
			
		}	
		
		// 通过map的value得到key
	    public  String getKeyByValue(Map map, Object value) 
	    {
	        // 首先得到entrySet的迭代器it
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
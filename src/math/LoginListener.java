package math;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class LoginListener implements ActionListener{
	private javax.swing.JTextField jtf1;
	private javax.swing.JPasswordField jpf1;
	private javax.swing.JFrame login;
	
	public LoginListener(javax.swing.JFrame login,javax.swing.JTextField jtf1,javax.swing.JPasswordField jpf1)
	{//��ȡ��¼���桢�˺�������������
		this.login=login;
		this.jtf1=jtf1;
		this.jpf1=jpf1;
	}
	
	int i=3;//3�ε�¼����
	
	public void actionPerformed(ActionEvent e)
	{
		Dimension dim2 = new Dimension(100,30);
		Dimension dim3 = new Dimension(300,30);
		
		//�����½���
		javax.swing.JFrame login2 = new javax.swing.JFrame();
		login2.setSize(400,200);
		login2.setDefaultCloseOperation(3);
		login2.setLocationRelativeTo(null);
		login2.setFont(new Font("����",Font.PLAIN,14));  //���壬�������14������
		//�������
		javax.swing.JPanel jp1 = new JPanel();
		javax.swing.JPanel jp2 = new JPanel();
		Jdbcs d = new Jdbcs();
        String username = jtf1.getText();
        String password = jpf1.getText();
        if (d.compare(username, password)) 
			
			{	
				new TestFrame();
				JLabel message = new JLabel("��½�ɹ���");
				
				message.setFont(new Font("����",Font.PLAIN,14));  //���壬�������14������
				message.setPreferredSize(dim3);
				jp1.add(message);
				login2.add(jp1,BorderLayout.CENTER);
				JButton join = new JButton("ȷ��");
				join.setSize(dim3);
				jp2.add(join);
				login2.add(jp2,BorderLayout.SOUTH);
				join.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						login2.dispose();
					}
				});
				
				login2.setResizable(false);
				login2.setVisible(true);
				
				//ͨ�����ǻ�ȡ�ĵ�¼���������dispose�����ر���
				login.dispose();
				
				
			}
			
			else if(i>=2)
			{
				JLabel message = new JLabel("�˺Ż��������,�����컹��"+(i-1)+"�λ���");
				message.setFont(new Font("����",Font.PLAIN,14));  //���壬�������14������
				message.setPreferredSize(dim3);
				//��textName��ǩ��ӵ�������
				jp1.add(message);
				login2.add(jp1,BorderLayout.CENTER);
				
				JButton close = new JButton("ȷ��");
				close.setFont(new Font("����",Font.PLAIN,14));
				//���ð�����С
				close.setSize(dim3);
				jp2.add(close);
				login2.add(jp2,BorderLayout.SOUTH);
				
				i--;//��������
				close.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						login2.dispose();
					}
				});
				
				login2.setResizable(false);
				login2.setVisible(true);
			}
			
			else if(i == 1)
			{
				JLabel message = new JLabel("�˺�������������������");
				message.setFont(new Font("����",Font.PLAIN,14));  //���壬�������14������
				message.setPreferredSize(dim3);
				//��textName��ǩ��ӵ�������
				jp1.add(message);
				login2.add(jp1,BorderLayout.CENTER);
				
				JButton close = new JButton("ȷ��");
				close.setFont(new Font("����",Font.PLAIN,14));
				//���ð�����С
				close.setSize(dim3);
				jp2.add(close);
				login2.add(jp2,BorderLayout.SOUTH);
				
				close.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						login2.dispose();
					}
				});
				
				login2.setResizable(false);
				login2.setVisible(true);
				
				//ͨ�����ǻ�ȡ�ĵ�¼���������dispose�����ر���
				login.dispose();
			}
	}

}
package math;

public class CreateFormula {
	int result;
	String formula;
	int[] answers;
	int right;
	int nandu;
	public CreateFormula()
	{   nandu=0;
		result=-1;
		formula=null;
		answers=new int[4];
		right=-1;
	}
	boolean p(int x)//��s<x���ʵķ���
	{
		int s=(int)(Math.random()*100);
		return s<x;
	}
	int getResult()//��ý��
	{
		return result;
	}

	int tiaozhennandu(int zz)
	{ nandu=zz;
		return 0;
	}

	String getFormula()//�����Ŀ
	{
		return formula;
	}
	int getAnswers(int index)//��ô�
	{
		return answers[index];
	}
	int getRight()//�����ȷ��
	{
		return right;
	}
	void setAnswers()//������ȷ�𰸺ʹ����
	{
		int wrong0,wrong1,wrong2;
		if(result==0) wrong0=1;
		else if(result==100) wrong0=99;
		else wrong0=p(50)?(result+1):(result-1);
		if(result<10) wrong1=result+10;
		else if(result>90) wrong1=result-10;
		else wrong1=p(50)?(result+10):(result-10);
		wrong2=(int)(Math.random()*100);
		while(wrong2==result || wrong2==wrong0 || wrong2==wrong1)
		{
			wrong2=(int)(Math.random()*100);
		}
		answers[0]=result;
		answers[1]=wrong0;
		answers[2]=wrong1;
		answers[3]=wrong2;
		right=0;
		for(int i=0;i<15;i++)//������ȷ�ʹ����˳��
		{
			int x=(int)(Math.random()*4);
			int y=(int)(Math.random()*4);
			while(x==y)
			{
				x=(int)(Math.random()*4);
				y=(int)(Math.random()*4);
			}
			if(x==right)
				right=y;
			else if(y==right)
				right=x;
			int tp=answers[x];//������ֵ
			answers[x]=answers[y];
			answers[y]=tp;
		}
	}
	void run()//�����������ʹ�
	{

		int p1,p2,p3;
		if(nandu==0)
		{ if(p(50))
		{
			p1=(int)(Math.random()*100);//a+b������Ŀ�ʹ�
			p2=(int)(Math.random()*100);
			while(p1+p2>100)
			{
				p1=(int)(Math.random()*100);
				p2=(int)(Math.random()*100);
			}
			formula=p1+"+"+p2;
			result=p1+p2;
		}
		else{
			p1=(int)(Math.random()*100);//a-b������Ŀ�ʹ�
			p2=(int)(Math.random()*100);
			while(p1-p2<0)
			{
				p1=(int)(Math.random()*100);
				p2=(int)(Math.random()*100);
			}
			formula=p1+"-"+p2;
			result=p1-p2;
		}

		}
		if(nandu==1)
		{ if(p(20))
		{
			p1=(int)(Math.random()*100);//a+b+c������Ŀ�ʹ�
			p2=(int)(Math.random()*100);
			p3=(int)(Math.random()*100);
			while(p1+p2+p3>100)
			{
				p1=(int)(Math.random()*100);
				p2=(int)(Math.random()*100);
				p3=(int)(Math.random()*100);
			}
			formula=p1+"+"+p2+"+"+p3;
			result=p1+p2+p3;
		}
		else
		{if(p(50))
		{ p1=(int)(Math.random()*100);//a*b������Ŀ�ʹ�
			p2=(int)(Math.random()*100);

			while(p1*p2>100||p2==1||p1==1)
			{
				p1=(int)(Math.random()*100);
				p2=(int)(Math.random()*100);

			}
			formula=p1+"*"+p2;
			result=p1*p2;
		}
		else
		{ if(p(80)){
			p1=(int)(Math.random()*100);//a/b������Ŀ�ʹ�
			p2=(int)(Math.random()*100);
			p3=p1*p2;
			while(p3>100||p2==0||p2==1||p1==1)
			{
				p1=(int)(Math.random()*100);
				p2=(int)(Math.random()*100);
				p3=p1*p2;
			}
			formula=p3+"/"+p2;
			result=p1;
		}
		else{
			p1=(int)(Math.random()*100);//a-b+c������Ŀ�ʹ�
			p2=(int)(Math.random()*100);
			p3=(int)(Math.random()*100);
			while(p1-p2<0 || p1-p2+p3>100)
			{
				p1=(int)(Math.random()*100);
				p2=(int)(Math.random()*100);
				p3=(int)(Math.random()*100);
			}
			formula=p1+"-"+p2+"+"+p3;
			result=p1-p2+p3;
		}

		}
		}
		}
		if(nandu==2)
		{ if(p(50))
		{ p1=(int)(Math.random()*100);//a*b������Ŀ�ʹ�
			p2=(int)(Math.random()*100);
			while(p1*p2>2000||p1*p2<101||p2==1||p1==1)
			{
				p1=(int)(Math.random()*100);
				p2=(int)(Math.random()*100);
			}
			formula=p1+"*"+p2;
			result=p1*p2;
		}
		else
		{ p1=(int)(Math.random()*100);//a/b������Ŀ�ʹ�
			p2=(int)(Math.random()*100);
			p3=p1*p2;
			while(p3>2000||p3<101||p2==1||p1==1)
			{
				p1=(int)(Math.random()*100);
				p2=(int)(Math.random()*100);
				p3=p1*p2;
			}
			formula=p3+"/"+p2;
			result=p1;
		}
		}
		setAnswers();
	}

}
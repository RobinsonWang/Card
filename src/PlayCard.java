import java.awt.*;
import java.util.*;


public class PlayCard {
	ArrayList<Integer> dragList,layerList,xlist,ylist;//�϶�һ���Ƶ�����;
	ArrayList<Integer> backList,spareList;
    ArrayList<Integer> list;//������������������
	int cardColor[],cardNum[];//��������ֱ�������¼�˿��ƵĻ�ɫ�����֣�
	int addLabel=0,backCount=24;//����ȫ�ֱ�����addLabel������¼list������λ�ã�
                                //backCount������¼deck_card���б��泯�ϵ�������
	int dragCount=0,highLay=0;//dragCount������ʾҪ�϶��������е�Ԫ�ظ�����
                              //highLay������ŵ�ǰ�����ͼ��ֵ��
    int backNum=1,backListLength=0,spareListLength=0,spareIndex=0;
    
    Point original=new Point(0,0);//������¼���ƶ�ǰ�����ꣻ
	boolean dragFlat=false;
	int originLayer=0;
	
//----------------------------------------------------------------------
	public PlayCard()
	{
		dragList=new ArrayList<Integer>();//���Ҫ�ƶ���label��ţ�
		layerList=new ArrayList<Integer>();//���Ҫ�ƶ���label��Ӧ��ͼ��ֵ��
		xlist=new ArrayList<Integer>();//��Ž�Ҫ�ƶ���label������¼�Դlabel��x����
		ylist=new ArrayList<Integer>();//��Ž�Ҫ�ƶ���label������¼�Դlabel��y����
		
		backList=new ArrayList<Integer>();
		spareList=new ArrayList<Integer>();
		randomCard();
		colorNum();
	}
//-----------------------------------------------------------------
	public void colorNum()//���������¼�˿��ƵĻ�ɫ�����֣�
	{
		cardColor=new int[52];
		cardNum=new int[52];
		for(int i=0;i<13;i++)
		{
			cardColor[i]=1;//����������1��ʾ��
			cardNum[i]=i+1;
		}
		for(int i=13;i<26;i++)
		{
			cardColor[i]=2;//����������2��ʾ��
			cardNum[i]=i-12;
		}
		for(int i=26;i<39;i++)
		{
			cardColor[i]=3;//÷��������3��ʾ��
			cardNum[i]=i-25;
		}
		for(int i=39;i<52;i++)
		{
			cardColor[i]=4;//��Ƭ������4��ʾ��
			cardNum[i]=i-38;
		}
	}
//--------------------------------------------------------------------
	public void randomCard()//����0~51֮��������
	{
		list=new ArrayList<Integer>();
        int n=52;
        Random rand=new Random();
        boolean bool[]=new boolean[n];
        
        int num=0;
        
        for (int i=0; i<n; i++)
        {
            do{
                //�������������ͬ����ѭ��
                num=rand.nextInt(n);    
             
            }while(bool[num]);
            bool[num]=true;
            list.add(num);
        }
        
	}
//-------------------------------------------------------------------

}

import java.awt.*;
import java.util.*;


public class PlayCard {
	ArrayList<Integer> dragList,layerList,xlist,ylist;//拖动一串牌的链表;
	ArrayList<Integer> backList,spareList;
    ArrayList<Integer> list;//用来存放随机数的链表；
	int cardColor[],cardNum[];//两个数组分别用来记录扑克牌的花色和数字；
	int addLabel=0,backCount=24;//两个全局变量，addLabel用来记录list的索引位置，
                                //backCount用来记录deck_card堆中背面朝上的牌数。
	int dragCount=0,highLay=0;//dragCount用来表示要拖动的链表中的元素个数，
                              //highLay用来存放当前的最大图层值；
    int backNum=1,backListLength=0,spareListLength=0,spareIndex=0;
    
    Point original=new Point(0,0);//用来记录牌移动前的坐标；
	boolean dragFlat=false;
	int originLayer=0;
	
//----------------------------------------------------------------------
	public PlayCard()
	{
		dragList=new ArrayList<Integer>();//存放要移动的label编号；
		layerList=new ArrayList<Integer>();//存放要移动的label对应的图层值；
		xlist=new ArrayList<Integer>();//存放将要移动的label相对于事件源label的x坐标差；
		ylist=new ArrayList<Integer>();//存放将要移动的label相对于事件源label的y坐标差；
		
		backList=new ArrayList<Integer>();
		spareList=new ArrayList<Integer>();
		randomCard();
		colorNum();
	}
//-----------------------------------------------------------------
	public void colorNum()//两个数组记录扑克牌的花色和数字；
	{
		cardColor=new int[52];
		cardNum=new int[52];
		for(int i=0;i<13;i++)
		{
			cardColor[i]=1;//红桃用数字1表示；
			cardNum[i]=i+1;
		}
		for(int i=13;i<26;i++)
		{
			cardColor[i]=2;//黑桃用数字2表示；
			cardNum[i]=i-12;
		}
		for(int i=26;i<39;i++)
		{
			cardColor[i]=3;//梅花用数字3表示；
			cardNum[i]=i-25;
		}
		for(int i=39;i<52;i++)
		{
			cardColor[i]=4;//方片用数字4表示；
			cardNum[i]=i-38;
		}
	}
//--------------------------------------------------------------------
	public void randomCard()//产生0~51之间的随机数
	{
		list=new ArrayList<Integer>();
        int n=52;
        Random rand=new Random();
        boolean bool[]=new boolean[n];
        
        int num=0;
        
        for (int i=0; i<n; i++)
        {
            do{
                //如果产生的数相同继续循环
                num=rand.nextInt(n);    
             
            }while(bool[num]);
            bool[num]=true;
            list.add(num);
        }
        
	}
//-------------------------------------------------------------------

}

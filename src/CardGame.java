import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * 
 * @author RobinsonWang
 *  2011年11月
 */
public class CardGame {
	PlayCard playcard;
	CardView cardview;
	CardPile cardpile;
	SuitPile suitpile;
	TablePile tablepile;
	DeckPile deckpile;
	
	public CardGame()
	{
		playcard=new PlayCard();
		cardview=new CardView();
		cardpile=new CardPile();
		suitpile=new SuitPile();
		tablepile=new TablePile();
		deckpile=new DeckPile();
		
		Initialize();
		
	}
	
//------------------------------------------------------
	public void Initialize()
	{
		cardview.mainJPanel.add(deckpile.returnCard,new Integer(5));
		deckpile.returnCard.setBounds(0,0,100,150);
		cardview.mainJPanel.add(cardpile.backCard[0],new Integer(10));
		cardpile.backCard[0].setBounds(0,0,100,150);
		
		for(int i=1;i<=7;i++)//建立中间的7个牌堆；
		{
			cardPile(i);
		}
		
		for(int i=0;i<4;i++)
		{
			int a=360+i*120;
			cardview.mainJPanel.add(suitpile.suitCard[i],new Integer(10));
			suitpile.suitCard[i].setBounds(a,0,100,150);
		}
		
		for(int i=0;i<7;i++)
		{
			int a=0+i*120;
			cardview.mainJPanel.add(tablepile.blueCard[i],new Integer(5));
			tablepile.blueCard[i].setBounds(a,170,100,150);
		}
		
		//响应backCard的鼠标点击事件；
		MouseListener smallMouse=new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(playcard.backCount>0 && playcard.spareListLength==0)
				{
					int a=playcard.list.get(playcard.addLabel);
					playcard.addLabel++;
					int b=24-playcard.backCount;
					b=b*10;
					cardview.mainJPanel.add(cardpile.cardLabel[a],new Integer(10+b));
					cardpile.cardLabel[a].setBounds(120,0,100,150);
					playcard.backCount--;
					if(playcard.backCount==0)
						cardpile.backCard[0].setVisible(false);
				}
				if(playcard.spareListLength>0)//当点击过一次returnCard之后，再点击backCard时；
				{
					int a=playcard.spareList.get(playcard.spareIndex);
					playcard.spareIndex++;
					int b=playcard.spareIndex*10;
					cardview.mainJPanel.add(cardpile.cardLabel[a],new Integer(10+b));
					cardpile.cardLabel[a].setBounds(120,0,100,150);
					if(playcard.spareIndex==playcard.spareListLength)
					{
						cardpile.backCard[0].setVisible(false);
						playcard.spareList.clear();
						playcard.spareListLength=0;
						playcard.spareIndex=0;
					}
						
				}
				
			}
			public void mouseEntered(MouseEvent e)
			{
				
			}
			public void mouseExited(MouseEvent e)
			{
				
			}
			public void mousePressed(MouseEvent e)
			{
				
			}
			public void mouseReleased(MouseEvent e)
			{
				
			}
		};
		
		//响应returnCard的鼠标点击事件；
		MouseListener smallMouse2=new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				//寻找位于spare_pile堆的扑克牌，将其放回deck_card堆中；
				for(int i=0;i<52;i++)
				{
					Point point=new Point(0, 0);
					point=cardpile.cardLabel[i].getLocation();
					int a=point.x;
					int b=point.y;
					if(a==120 && b==0)
					{
						playcard.spareList.add(i);
						playcard.spareListLength++;
						cardview.mainJPanel.remove(cardpile.cardLabel[i]);//暂时将这张牌从面板上移除；
						
					}
				}
				if(playcard.spareListLength>0)
				{
					cardpile.backCard[0].setVisible(true);
				}
				//解决容器组件的刷新问题；
				cardview.mainJPanel.invalidate();
				cardview.mainJPanel.validate();
				cardview.mainJPanel.repaint();
			}
			public void mouseEntered(MouseEvent e)
			{
				
			}
			public void mouseExited(MouseEvent e)
			{
				
			}
			public void mousePressed(MouseEvent e)
			{
				
			}
			public void mouseReleased(MouseEvent e)
			{
				
			}
		};
		
		cardpile.backCard[0].addMouseListener(smallMouse);
		deckpile.returnCard.addMouseListener(smallMouse2);
		
		dragMouse smallDragMouse=new dragMouse();
		//为所有的正面扑克label添加监听器；
		for(int i=0;i<52;i++)
		{
			//注意~~~~smallDragMouse一定要按如下方式添加两次；
			cardpile.cardLabel[i].addMouseListener(smallDragMouse);
			cardpile.cardLabel[i].addMouseMotionListener(smallDragMouse);
		}
		
        		
		
	}
//------------------------------------------------------
	public void cardPile(int k)//初始化7个牌堆，k的值为1~7；
	{
		for(int i=0;i<k;i++)
		{
			int a=playcard.list.get(playcard.addLabel);
			playcard.addLabel++;
			int b=i*10;
			int x=0+(k-1)*120;
			int y=170+i*3;
			
			cardview.mainJPanel.add(cardpile.cardLabel[a],new Integer(10+b));
			cardpile.cardLabel[a].setBounds(x,y,100,150);
			
			if(i!=k-1)
			{
				cardpile.cardLabel[a].setVisible(false);
				cardview.mainJPanel.add(cardpile.backCard[playcard.backNum],new Integer(10+b));
				cardpile.backCard[playcard.backNum].setBounds(x,y,100,150);
				playcard.backList.add(playcard.backNum);
				playcard.backListLength++;
				playcard.backNum++;
			}
			
		}
	}
//---------------------------------------------------------------
	private class dragMouse extends MouseInputAdapter//内部类，用来处理拖动纸牌的事件；
	{
		public void mouseDragged(MouseEvent e)//当拖动label时触发的事件；
		{
			Point point=new Point(0, 0);//用来存放要拖动的label的当前坐标；
			Point point2=new Point(0, 0);//用来存放位于要拖动的label上面的label的当前坐标；
			
			
			for(int i=0;i<52;i++)
			{
				if(e.getSource()==cardpile.cardLabel[i])//确定事件源；
				{
					int f=cardview.mainJPanel.getLayer(cardpile.cardLabel[i]);//得到事件源label所位于的图层；
					point=cardpile.cardLabel[i].getLocation();
					
					
					if(point.y>150)
					{
						for(int j=0;j<52;j++)//此循环用来寻找位于事件源label上面的label;
						{
							int d=cardview.mainJPanel.getLayer(cardpile.cardLabel[j]);
							if(j!=i && d>f)//此条件筛选出图层位于事件源label之上的label;
							{
								point2=cardpile.cardLabel[j].getLocation();
								int b=point2.x-point.x;
								int c=point2.y-point.y;
								if(b>-10 && b<10 && c>0)//此条件通过位置进行筛选；
								{
									playcard.dragList.add(j);//将符合条件的label编号存入链表中；
									playcard.layerList.add(d);//将对应的图层存入链表中；
									playcard.xlist.add(b);//将相对于事件源label的x坐标差存入链表中；
									playcard.ylist.add(c);//将相对于事件源label的y坐标差存入链表中；
									playcard.dragCount++;//记录链表中元素的个数；
								}
							}
						}
					}
					
					
					//将事件源label移动到新位置；
					cardpile.cardLabel[i].setLocation(e.getPoint().x+point.x,
		        			e.getPoint().y+point.y);
					playcard.highLay=cardview.mainJPanel.highestLayer();//highLay存放当前图层的最大值；
					cardview.mainJPanel.remove(cardpile.cardLabel[i]);
					cardview.mainJPanel.add(cardpile.cardLabel[i],new Integer(playcard.highLay+10));
					
					playcard.dragFlat=true;
					
					break;
				}
			}
		}
		public void mouseReleased(MouseEvent e)//当松开鼠标时触发的事件；
		{
			//System.out.println("***********"+dragCount);
			for(int i=0;i<52;i++)
			{
				if(e.getSource()==cardpile.cardLabel[i])//得到事件源；
				{
					
					//System.out.println("***********************!!");
					if(playcard.dragFlat && cardpile.cardLabel[i].getLocation().y>150)
					{
						checkRule(i);
						playcard.dragFlat=false;
					}
					if(playcard.dragFlat && cardpile.cardLabel[i].getLocation().y<100)
					{
						checkSuit(i);
						playcard.dragFlat=false;
					}
					checkWin();
					
					for(int k=0;k<playcard.dragCount;k++)//取出链表中的元素；
					{
						int j=playcard.dragList.get(k);//得到将要移动的label；
						int d=playcard.layerList.get(k);//得到将要移动的label原来所处于的图层；
						int b=playcard.xlist.get(k);//得到将要移动的label相对于事件源label的x坐标差；
						int c=playcard.ylist.get(k);//得到将要移动的label相对于事件源label的y坐标差；
						//将label移动到新位置；
						cardpile.cardLabel[j].setLocation(cardpile.cardLabel[i].getLocation().x+b,
								cardpile.cardLabel[i].getLocation().y+c);
						cardview.mainJPanel.remove(cardpile.cardLabel[j]);
						cardview.mainJPanel.add(cardpile.cardLabel[j],new Integer(playcard.highLay+10+d));
					}
					//清空用过的链表，因为别的触发事件还要用到；
					playcard.dragList.clear();
					playcard.layerList.clear();
					playcard.xlist.clear();
					playcard.ylist.clear();
					playcard.dragCount=0;
					
					scanBack();
					
					break;
				}
			}
			
		}
		public void mousePressed(MouseEvent e)//当鼠标被按下时触发的事件；
		{
			for(int i=0;i<52;i++)
			{
				if(e.getSource()==cardpile.cardLabel[i])//得到事件源；
				{
					//将这张牌移动前的位置记录下来；
					playcard.original=cardpile.cardLabel[i].getLocation();
					playcard.originLayer=cardview.mainJPanel.getLayer(cardpile.cardLabel[i]);
				}
			}
		}
	}
//---------------------------------------------------------------
	public void checkRule(int k)//检查中间7个堆的扑克牌放置是否符合规则；
	{
		Point point=new Point(0,0);
		Point point2=new Point(0,0);
		ArrayList<Integer> adjustList;
		adjustList=new ArrayList<Integer>();
		int adjustListLength=0,top=0;
		
		point=cardpile.cardLabel[k].getLocation();
		for(int i=0;i<52;i++)
		{
			if(i!=k)
			{
				point2=cardpile.cardLabel[i].getLocation();
				int a=point2.x-point.x;
				int b=point2.y-point.y;
				if(a>-10 && a<10 && b<0 && point2.y>=170)
				{
					adjustList.add(i);
					adjustListLength++;
				}
			}
		}
		if(adjustListLength==0)
		{
			if(playcard.cardNum[k]==13)
			{
				if(point.x<20)
					cardpile.cardLabel[k].setLocation(0,170);
				if(point.x>=110 && point.x<=130)
					cardpile.cardLabel[k].setLocation(120,170);
				if(point.x>=230 && point.x<=250)
					cardpile.cardLabel[k].setLocation(240,170);
				if(point.x>=350 && point.x<=370)
					cardpile.cardLabel[k].setLocation(360,170);
				if(point.x>=470 && point.x<=490)
					cardpile.cardLabel[k].setLocation(480,170);
				if(point.x>=590 && point.x<=610)
					cardpile.cardLabel[k].setLocation(600,170);
				if(point.x>=710 && point.y<=730)
					cardpile.cardLabel[k].setLocation(720,170);
			}
			else
			{
				cardpile.cardLabel[k].setLocation(playcard.original);
			}
		}
		if(adjustListLength>0)
			top=adjustList.get(0);
		for(int i=1;i<adjustListLength;i++)
		{
			int a=adjustList.get(i);
			int b=cardpile.cardLabel[top].getLocation().y;
			int c=cardpile.cardLabel[a].getLocation().y;
			
			if(c>b)
				top=a;
		}
		if(adjustListLength>0)
		{
			int a=playcard.cardColor[k];
			int b=playcard.cardColor[top];
			int c=playcard.cardNum[k];
			int d=playcard.cardNum[top];
			
			if((a+b!=5) && (c==d-1) && (a!=b))
			{
				point2=cardpile.cardLabel[top].getLocation();
				cardpile.cardLabel[k].setLocation(point2.x,point2.y+20);
			}
			else
			{
				cardpile.cardLabel[k].setLocation(playcard.original);
			}
		}
		
	}
//--------------------------------------------------------------
	public void checkSuit(int k)//检查suit_card堆的放置是否符合规则；
	{
		Point point=new Point();
		Point point2=new Point(0,0);
		
		ArrayList<Integer> suitList;
		suitList=new ArrayList<Integer>();
		
		int suitListLength=0,top=0;
		
		point=cardpile.cardLabel[k].getLocation();
		
		for(int i=0;i<52;i++)
		{
			if(i!=k)
			{
				point2=cardpile.cardLabel[i].getLocation();
				int a=point2.x-point.x;
				int b=point2.y-point.y;
				if(a>-10 && a<10 && point2.y==0)
				{
					suitList.add(i);
					suitListLength++;
				}
			}
		}
		if(suitListLength==0)
		{
			if(playcard.cardNum[k]==1)
			{
				if(point.x>=350 && point.x<=380)
					cardpile.cardLabel[k].setLocation(360,0);
				if(point.x>=470 && point.x<=500)
					cardpile.cardLabel[k].setLocation(480,0);
				if(point.x>=590 && point.x<=620)
					cardpile.cardLabel[k].setLocation(600,0);
				if(point.x>=710 && point.y<=740)
					cardpile.cardLabel[k].setLocation(720,0);
			}
			else
			{
				cardpile.cardLabel[k].setLocation(playcard.original);
				cardview.mainJPanel.remove(cardpile.cardLabel[k]);
				cardview.mainJPanel.add(cardpile.cardLabel[k],new Integer(playcard.originLayer));
			}
		}
		if(suitListLength>0)
			top=suitList.get(0);
		for(int i=1;i<suitListLength;i++)
		{
			int a=suitList.get(i);
			int b=cardview.mainJPanel.getLayer(cardpile.cardLabel[top]);
			int c=cardview.mainJPanel.getLayer(cardpile.cardLabel[a]);
			
			if(c>b)
				top=a;
		}
		if(suitListLength>0)
		{
			int a=playcard.cardColor[k];
			int b=playcard.cardColor[top];
			int c=playcard.cardNum[k];
			int d=playcard.cardNum[top];
			
			if((a==b) && (c==d+1))
			{
				point2=cardpile.cardLabel[top].getLocation();
				cardpile.cardLabel[k].setLocation(point2);
			}
			else
			{
				cardpile.cardLabel[k].setLocation(playcard.original);
				cardview.mainJPanel.remove(cardpile.cardLabel[k]);
				cardview.mainJPanel.add(cardpile.cardLabel[k],new Integer(playcard.originLayer));
			}
		}
		
	}
//----------------------------------------------------------------
	public void checkWin()//检查本局游戏是否获胜；
	{
		Point point1=new Point(0,0);
		Point point2=new Point(0,0);
		Point point3=new Point(0,0);
		Point point4=new Point(0,0);
		
		point1=cardpile.cardLabel[12].getLocation();
		point2=cardpile.cardLabel[25].getLocation();
		point3=cardpile.cardLabel[38].getLocation();
		point4=cardpile.cardLabel[51].getLocation();
		
		if(point1.x>300 && point1.y==0 && point2.x>300 && point2.y==0
		    && point3.x>300 && point3.y==0 && point4.x>300 && point4.y==0)
		{
			//System.out.println("You have won this game !");
			smallWindow();
		}
		else
		{
			//System.out.println("Go on to play this game !");
		}
	}
//-----------------------------------------------------------------
	public void scanBack()//扫描7个堆中的backCard，如果位于最顶层，则“自动翻开”；
  	{
  		for(int i=0;i<playcard.backListLength;i++)
  		{
  			Point point=new Point(0, 0);
  			Point point2=new Point(0, 0);
  			
  			int top=-1;//此变量用来判断上层牌的情况；
  			int block=-1;//此变量用来记录正好被backCard挡住的那张cardLabel的索引；
  			int a=playcard.backList.get(i);
  			point=cardpile.backCard[a].getLocation();
  			//判断该backCard是否是最上层的backCard;
  			for(int j=0;j<playcard.backListLength && top!=0;j++)
  			{
  				if(j!=i)
  				{
  					int b=playcard.backList.get(j);
  					point2=cardpile.backCard[b].getLocation();
  					int c=point2.x-point.x;
					int d=point2.y-point.y;
					if(c>-10 && c<10 && d>0)
					{
						top=0;//存在另一张backCard在其上层；
					}
  				}
  			}
  			//判断该backCard上层是否有正面朝上的牌；
  			for(int j=0;j<52 && top!=0 && top!=1;j++)
  			{
  				point2=cardpile.cardLabel[j].getLocation();
  				int c=point2.x-point.x;
				int d=point2.y-point.y;
				if(c==0 && d==0)
				{
					block=j;
				}
				if(c>-10 && c<10 && d>0)
				{
					top=1;//上层存在正面朝上的牌；
				}
  			}
  			//如果该backCard是所在的牌堆的最上层牌，则“翻转”；
  			if(top!=0 && top!=1)
  			{
  				cardpile.cardLabel[block].setVisible(true);
  				cardview.mainJPanel.remove(cardpile.backCard[a]);//从面板上去掉这张backCard;
  				playcard.backList.remove(i);//不要忘记对应的链表中也要相应的移除这张牌；
  				playcard.backListLength--;
  				i--;//由于删除一个元素后，链表的元素会自动前移，所以要将扫描游标前移一个位置；
  			}
  		}
  	}
//-----------------------------------------------------------------
	public void smallWindow()
	{
		JFrame winFrame;
		JLabel winLabel;
		
		winFrame=new JFrame("游戏获胜");
		winLabel=new JLabel("太牛了！恭喜你！");
		winLabel.setIcon(new ImageIcon("image/fireworks.gif"));
		
		winFrame.getContentPane().add(winLabel);
		winFrame.setSize(400,300);
		winFrame.setLocationRelativeTo(cardview.mainJFrame);
		winFrame.setVisible(true);
		winFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
//-----------------------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardGame cardgame=new CardGame();

	}

}

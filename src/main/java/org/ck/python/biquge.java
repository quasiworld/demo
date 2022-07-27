package org.ck.python;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JProgressBar;
public class biquge {

	   public biquge(String nn,String start,JProgressBar jpbVal,JProgressBar jpb2) {
	        long t1 = System.currentTimeMillis();
	        
	        //查找小说
	        Connection connection1 = Jsoup.connect("http://www.xbiquge.la/xiaoshuodaquan/");
	        
	        Document document1 = null;
			try {
				document1 = connection1.get();
			} catch (IOException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			}
	        Elements elementsLis1=null;
			try {
	        Element elementUL1 = document1.select("[class=novellist]").first();
	        elementsLis1 = elementUL1.select("li");
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			jpbVal.setVisible(true);
			int count = 0;
	        //巡官遍历获取到的整个elementsLis集合
	        for(Element elementLi1 : elementsLis1){
	        	
	        	try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
	        	
	            Element elementA1 = elementLi1.select("a").first();      
	            String href = elementA1.attr("href");//获取标签中的属性值（它这里采用的是相对路径的写法
	            String novelNa = elementA1.text();//小说名
	            
	            
	            jpbVal.setMaximum(elementsLis1.size());
	            
	          
	            
	            int result1 = novelNa.indexOf(nn);//匹配小说名
	            if(result1 != -1){
	            	//跟进小说
	            	jpbVal.setValue(elementsLis1.size());
	            	//JOptionPane msg = new JOptionPane();
	            	//msg.setBounds(100, 100, 100, 100);
	            	//JOptionPane.showMessageDialog(jpb2,"已找到小说："+novelNa);
	            	connectNovel(novelNa,href,start,jpb2);
	            	break;
	            	
	            }else{
	            	//继续往下寻找
	            	//System.out.println("未找到小说!");
	            	jpbVal.setValue(count);
	            }
	            count++;
	            if(count>=elementsLis1.size()) {
	            	System.out.println("未找到小说!");
	            }
	           
	    }
	   }    

	  public void connectNovel(String novelNa,String h,String start,JProgressBar jpb2) {
	        //1.与我们要爬取数据的页面建立连接
	       Connection connection = Jsoup.connect(h);
	        
	        jpb2.setVisible(true);

	        Document document = null;
			try {
				document = connection.get();
			} catch (IOException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			}
	  
	        Element elementUL = document.select("[id=list]").first();
	        Elements elementsLis = elementUL.select("dd");

	     //小说信息
	        Element el = document.select("[id=info]").first();
	        Elements ele = el.select("p");
	        String str1=ele.text().substring(0, ele.text().indexOf("部"));
	        String str2=ele.text().substring(str1.length()+1, ele.text().length());
	        System.out.println(str2);
	        
	        int midTime = elementsLis.size();//单位s
	        //所需时间
	        jpb2.setMaximum(midTime);
	        //residueTime(midTime);//倒计时
	        
	        
	       int  count2=0;
	      
	          boolean flag = false;
	          
	          int  count=0;
	          int count3=0;
	          jpb2.setMaximum(elementsLis.size());
	        //巡官遍历获取到的整个elementsLis集合
	        for(Element elementLi : elementsLis){
	        	try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
	        	
	            Element elementA = elementLi.select("a").first();      
	            String href = elementA.attr("href");//获取标签中的属性值（它这里采用的是相对路径的写法）

	            String imgName = elementA.text();
	            	
	            	count3++;
	          
	   	     

	            int result1 = imgName.indexOf(start);//匹配章节
	            if(result1 != -1){
	            	//开始下载
	            	
	            	try {
						download(novelNa,href,imgName);
						count++;
						
						jpb2.setMinimum(count3);
						jpb2.setValue(jpb2.getMinimum()+(count2++));
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
	            	flag = true;
	            }else{
	            	//继续往下寻找
	            	if(flag == true) {
	            		try {
							download(novelNa,href,imgName);
							count++;
							jpb2.setValue(jpb2.getMinimum()+(count2++));
						} catch (IOException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
	            	}
	            }

	           if(count3==elementsLis.size())
	           {
				   System.out.println("下载完成     共  "+count+" 章");
	        	   jpb2.setValue(jpb2.getMaximum());
	           }
	    }
	        
	        
	   }    

	    public static void download(String novelNa,String href,String imgName) throws IOException {
	    	 String netPath = "http://www.xbiquge.la"+href;

	            Connection newConnection = null; 
	            Document newDocument  = null; 
	            
	            try {
					Thread.sleep(100);
					 
	                 newConnection = Jsoup.connect(netPath);
	                 Thread.sleep(500);
	                  newDocument = newConnection.get();
				} catch(HttpStatusException e) {
					System.out.println("下载错误,尝试重新连接");
					 try {
							Thread.sleep(500);
							 
			                 newConnection = Jsoup.connect(netPath);
			                 Thread.sleep(1000);
			                  newDocument = newConnection.get();
						} catch(HttpStatusException e1) {
							System.out.println("下载错误2,尝试重新连接");
							
						} catch
			            (InterruptedException e3) {
							
							e.printStackTrace();
						}
					
				}
	            catch
	            (InterruptedException e) {
				
					e.printStackTrace();
				}
	          
	            
	            try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					
					e1.printStackTrace();
				}
	            
	            Element div = newDocument.select("[id=content]").first();
	         
	            String divStyle = div.attr("style");
	            String text = div.text().trim();
	            text = new String(text.getBytes("UTF-8"),"UTF-8");
	            String l = System.getProperty("line.separator");
	            
	        text = text.replace("。", "。"+l);
	       // System.out.print(text);
	            System.out.print("正在下载："+imgName+"    ");
	            FileOutputStream fileOutputStream = new FileOutputStream("./"+novelNa+".txt",true);
	            fileOutputStream.write(l.getBytes("UTF-8"));
	            fileOutputStream.write(imgName.getBytes("UTF-8"));
	            fileOutputStream.write(l.getBytes("UTF-8"));
	            fileOutputStream.write(text.getBytes("UTF-8"));//不指定则空格乱码，iso编码
	            fileOutputStream.flush();
	            fileOutputStream.close();
	            System.out.println("下载完成");
	           
	        	//dmu.ta.append("正在下载："+imgName+"    \n");
	        	
	        long t4 = System.currentTimeMillis();
	        //double time = (double) (t4-t1)/1000;
	       // System.out.println("恭喜您已完成全部下载，共耗时："+time+"秒，下载"+"章");
	    }
}
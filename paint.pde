//PENG
//0510


Table tb;
ArrayList<Integer> x = new ArrayList<Integer>();
ArrayList<Integer> y = new ArrayList<Integer>();
ArrayList<Integer> xx = new ArrayList<Integer>();
ArrayList<Integer> yy = new ArrayList<Integer>();
ArrayList<Integer> countArr = new ArrayList<Integer>();
int count = 0;
int lineCount = 0;

void setup(){
  
  size(512,512,P3D);
  background(255);
  
}

void draw(){
  

  
  tb = new Table();
  tb.addColumn("x");
  tb.addColumn("y");
  tb.addColumn("count");
  
  if(mousePressed){
    
    x.add(mouseX);
    y.add(mouseY);

    if(lineCount>0){
      line(x.get(lineCount),y.get(lineCount),x.get(lineCount-1),y.get(lineCount-1));
    }
    lineCount++;
    
  }
  
  else{
    
    lineCount = 0;
    x.clear();
    y.clear();

  }
   
  for(int j=1; j<x.size(); j++){
    if(x.get(j)!=x.get(j-1) || y.get(j)!=y.get(j-1)){
      xx.add(x.get(j));
      yy.add(y.get(j));
      countArr.add(count);
    }
  }
  
  if(lineCount==1){
 
      count++;
      println(countArr);
  }

    
  for(int n=0; n<xx.size(); n++){
     TableRow newRow = tb.addRow();
     newRow.setInt("x",xx.get(n));
     newRow.setInt("y",yy.get(n));
     newRow.setInt("count",countArr.get(n));
  }
  saveTable(tb,"Sketch.csv");
    
  stroke(0);
 

  
}

//void mouseClicked(){
      
//    count++;
//    println(count);
//}

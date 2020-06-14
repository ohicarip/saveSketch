import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class savesketch_0612 extends PApplet {

Table tb;
Table ltb;

ArrayList<Integer> x = new ArrayList<Integer>();
ArrayList<Integer> y = new ArrayList<Integer>();
ArrayList<Integer> xx = new ArrayList<Integer>();
ArrayList<Integer> yy = new ArrayList<Integer>();
ArrayList<Integer> countArr = new ArrayList<Integer>();

int count = 0;
int lineCount = 0;
int sx, sy;
int ttlx, ttly;
int cx, cy;
int ccount;
int initcount = 1;

public void setup(){
  
  
  background(255);
  
}

public void draw(){
  

  
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

public void keyPressed(){
  switch(key){
  case 's':
    ltb = loadTable("Sketch.csv","header");
    

    for (int i=initcount; i<ltb.getRowCount()-1; i++){
    
        sx = ltb.getInt(i,0);
        sy = ltb.getInt(i,1);
        ttlx = ttlx + sx;
        ttly = ttly + sy;
        ccount++;
    }
   
    cx = ttlx/ccount;
    cy = ttly/ccount;
    fill(200,0,0);
    noStroke();
    circle(cx,cy,10);
    
    ttlx = 0;
    ttly = 0;
    
    initcount = initcount + ccount;
    ccount =0;
    println(initcount);
    
    
    
  }
}
  public void settings() {  size(512,512,P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "savesketch_0612" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

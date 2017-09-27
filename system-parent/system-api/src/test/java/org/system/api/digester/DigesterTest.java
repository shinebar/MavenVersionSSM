package org.system.api.digester;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.digester.Digester;
import org.junit.Test;
import org.xml.sax.SAXException;

public class DigesterTest {
	
   @Test
   public void testDigester(){
	   InputStream xml = this.getClass().getResourceAsStream("/digester-config/test.xml");
	   Digester digester = new Digester();
       digester.addObjectCreate( "student" , "org.system.api.digester.Student" );
       digester.addSetProperties("student");
       digester.addObjectCreate("student/subjects" , "org.system.api.digester.Subjects");
       digester.addSetProperties("student/subjects");
       digester.addSetNext("student/subjects" , "add" );
       Student student = null;
       try {
           student = (Student)digester.parse(xml);
       }catch ( SAXException | IOException e ){
           System.out.println("parse with mistakes!");
           e.printStackTrace();
       }finally {
		 try {
			xml.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	   }
       Iterator<Subjects> it = student.getList().iterator();
       while ( it.hasNext()) {
          System.out.println("iterator :\t"+it.next());
       }
   }
   @Test
   public void testReflection(){
	   try {
			Class<?> clazz =this.getClass().getClassLoader().loadClass("org.system.api.digester.Student");
			Object obj=clazz.newInstance();
			BeanUtils.populate(obj, new HashMap<>());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
}

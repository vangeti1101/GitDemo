package data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class datareader {


 public List<HashMap<String, String>> getjsondatatomap(String filepath) throws IOException 
 {
//convert json to string
	String jsoncontent=FileUtils.readFileToString(new File(filepath),
			StandardCharsets.UTF_8);
 
 //convert string to hashmap dependency-Jackson Databind
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String, String>> data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){
	});
 
         return data;
 
 
 
 }


	
}














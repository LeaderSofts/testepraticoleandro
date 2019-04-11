package br.com.leadersofts.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.StringUtils;

/*
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
*/

import br.com.leadersofts.spring.model.Cliente;

public class ClienteDAO  {
		
	JdbcTemplate template;  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	public void save(Cliente c) {
		String sql="INSERT INTO clientes(nome,cpf,nascto,peso,uf) VALUES ('"
			+c.getNome()+"','"+c.getCpf()+"','"+c.getNascto()+"','"+c.getPeso().toString() +"','"+c.getUF()+"')";
		System.out.println(sql);
	    template.update(sql);  
	}
	
	private String convertListToDelimitedString(List<String> list) {

		String resultado = "";
		if (list != null) {
			resultado = StringUtils.arrayToCommaDelimitedString(list.toArray());
		}
		return resultado;
	}
	
	public List<Cliente> listaClientes() {
				
		return template.query("select * from clientes",new ResultSetExtractor<List<Cliente>>(){  
		    
		     public List<Cliente> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
					List<Cliente> lista = new ArrayList<Cliente>();  
					while(rs.next()){  
					Cliente c=new Cliente();  
					c.setId_cliente(rs.getInt(1));  
					c.setNome(rs.getString(2));  
					c.setCpf(rs.getString(3));  
					c.setNascto(rs.getString(4));
					c.setPeso(rs.getDouble(5));
					c.setUF(rs.getString(6));
					c.setFirstAttempt(rs.getBoolean(7));
					c.setSubjects(convertDelimitedStringToList(rs.getString(8)));					
					lista.add(c);  
		        }  
					return lista;  
		        }  
		    });  	
	}
	
	public List<Cliente> getclientesByPage(int pageid, int total) {
		// TODO Auto-generated method stub
		 String sql="select * from clientes limit "+(pageid-1)+","+total;  
		 return template.query(sql,new ResultSetExtractor<List<Cliente>>(){  
		    
		     public List<Cliente> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Cliente> lista = new ArrayList<Cliente>();  
		        
		        while(rs.next()){  
			        Cliente c=new Cliente();  
			        c.setId_cliente(rs.getInt(1));  
					c.setNome(rs.getString(2));  
					c.setCpf(rs.getString(3));  
					c.setNascto(rs.getString(4));
					c.setPeso(rs.getDouble(5));
					c.setUF(rs.getString(6));
					c.setFirstAttempt(rs.getBoolean(7));
					c.setSubjects(convertDelimitedStringToList(rs.getString(8)));
		        	lista.add(c);  
		        }  
		        return lista;  
		        }  
		    });  
		  }
	
	public Cliente getClienteById(int id) {
		// TODO Auto-generated method stub
				 return template.query("select * from clientes where id_cliente="+id,new ResultSetExtractor<Cliente>(){  
					    
					 public Cliente extractData(ResultSet rs) throws SQLException,  
				     	DataAccessException {  
				      
						 Cliente c = new Cliente();  
						 while(rs.next()){  
				       
							 c.setId_cliente(rs.getInt(1));  
							 c.setNome(rs.getString(2));  
							 c.setCpf(rs.getString(3));  
							 c.setNascto(rs.getString(4));
							 c.setPeso(rs.getDouble(5));
							 c.setUF(rs.getString(6));
							 c.setFirstAttempt(rs.getBoolean(7));
							 c.setSubjects(convertDelimitedStringToList(rs.getString(8)));
						 }  
				        return c;  
					 }  
				 });  
	}
	
	private static List<String> convertDelimitedStringToList(String delimitedString) {

		List<String> lista = new ArrayList<String>();

		if (!StringUtils.isEmpty(delimitedString)) {
			lista = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
		}
		return lista;
	}
	
	public void update(Cliente c) {
		String sql="UPDATE clientes SET nome='"+c.getNome()+"',cpf='"+c.getCpf()+"',nascto='"+c.getNascto()+
		"',peso='"+c.getPeso().toString() + "',uf='"+c.getUF()+"' WHERE ID="+c.getId_cliente()+"";
		System.out.println(sql);
       template.update(sql);  
	}
	public void delete() {
		// TODO Auto-generated method stub
		String sql="delete from Cliente WHERE ID>0";  
	    template.update(sql); 
	}

	public int count() {
		String sql="select count(*) from clientes";
		int count = template.queryForObject(sql,Integer.class);
		return count;
	}
	/*public String ConvertDate(Date date){
		String formatedDate ="";
	    try{
				DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
				date = (Date)formatter.parse(date.toString());
				Calendar cal = Calendar.getInstance();
			   
			    cal.setTime(date);
			    
			    formatedDate=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH) + 1)+"-"+cal.get(Calendar.DATE);
		}catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
	    return formatedDate;
	}*/
	
	/*
	 * public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from Cliente WHERE ID="+id+"";  
	    template.update(sql);    
	}	
	*/

}

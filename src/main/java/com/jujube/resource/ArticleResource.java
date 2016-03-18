package com.jujube.resource;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.alibaba.fastjson.JSON;
import com.jujube.constants.ResourceConstatns;
import com.jujube.model.Article;
import com.jujube.util.ConfigUtil;

@Path(ResourceConstatns.Route.ROUTE_ARTICLE)
@Produces(MediaType.APPLICATION_JSON)
public class ArticleResource {

	@GET
	@Path("/{id}")
	public Response getArticle(@PathParam("id") String id){
		
		Article article = new Article();
		article.setId(id);
		article.setTitle("论期末数-"+"bouckt-"+ConfigUtil.get("qiniu/qiniu.properties", "bouckt"));
		article.setContent("水电开发建设东风开始大举分"+"test:"+ConfigUtil.get("app.properties", "test"));
		article.setCreateDate(new Date());
		
		String json = JSON.toJSONString(article);
		return Response.status(Status.OK).entity(json).type(MediaType.APPLICATION_JSON).build();
		
	}
}

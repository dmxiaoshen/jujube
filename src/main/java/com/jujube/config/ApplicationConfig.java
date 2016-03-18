package com.jujube.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.jujube.resource.ArticleResource;

public class ApplicationConfig extends ResourceConfig{

	public ApplicationConfig(){
		register(ArticleResource.class);
	}
}

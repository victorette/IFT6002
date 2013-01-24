package ca.ulaval.ift6002.lab1.repertoire;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import ca.ulaval.ift6002.lab1.repertoire.servlet.HelloWorldServlet;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int httpPort = 8080;

		Server server = new Server(httpPort);
		ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/");
		servletContextHandler.addServlet(new ServletHolder(HelloWorldServlet.class), "/index");

		ServletHolder jerseyServletHolder = new ServletHolder(ServletContainer.class);
		jerseyServletHolder.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
		jerseyServletHolder.setInitParameter("com.sun.jersey.config.property.packages", "ca.ulaval.ift6002.lab1.repertoire.rest");
		servletContextHandler.addServlet(jerseyServletHolder, "/*");
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

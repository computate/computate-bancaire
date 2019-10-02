package org.computate.bancaire.enus.vertx;

import org.computate.bancaire.enus.contexte.SiteContextEnUS;
import org.computate.bancaire.enus.request.SiteRequestEnUS;
import org.computate.bancaire.enus.wrap.Wrap;
import org.computate.bancaire.frfr.vertx.AppliOpenApi3Gen;

public class AppOpenApi3 extends AppOpenApi3Gen<AppSwagger2> {

	@Override()
	protected void  _apiVersion(Wrap<String> c) {
		c.o("3.0.0");
	}

	public static void  main(String[] args) {
		AppOpenApi3 api = new AppOpenApi3();
		SiteContextEnUS siteContext = new SiteContextEnUS();
		siteContext.initDeepSiteContextEnUS(null);
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
		siteRequest.setSiteContext_(siteContext);
		siteRequest.setSiteConfig_(siteContext.getSiteConfig());
		siteRequest.initDeepSiteRequestEnUS();
		api.initDeepAppOpenApi3(siteRequest);
		api.writeOpenApi();
	}
}

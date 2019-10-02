package org.computate.bancaire.enus.user;

import org.computate.bancaire.enus.contexte.SiteContextEnUS;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.ext.web.api.generator.WebApiServiceGen;
import io.vertx.serviceproxy.ServiceBinder;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.web.api.OperationResponse;

/**
 * Translate: false
 * classCanonicalName.frFR: org.computate.bancaire.frfr.utilisateur.UtilisateurSiteFrFRGenApiService
 * Gen: false
 **/
@WebApiServiceGen
@ProxyGen
public interface SiteUserEnUSGenApiService {
	static void registerService(SiteContextEnUS siteContext, Vertx vertx) {
		new ServiceBinder(vertx).setAddress("enUSSiteUser").register(SiteUserEnUSGenApiService.class, new SiteUserEnUSApiServiceImpl(siteContext));
	}

	static SiteUserEnUSGenApiService create(SiteContextEnUS siteContext, Vertx vertx) {
		return new SiteUserEnUSApiServiceImpl(siteContext);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static SiteUserEnUSGenApiService createProxy(Vertx vertx, String address) {
		return new SiteUserEnUSGenApiServiceVertxEBProxy(vertx, address);
	}

	public void patchSiteUser(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageSiteUserId(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageSiteUser(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
}

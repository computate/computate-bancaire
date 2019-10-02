package org.computate.bancaire.enus.account;

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
 * classCanonicalName.frFR: org.computate.bancaire.frfr.compte.CompteBancaireFrFRGenApiService
 * Gen: false
 **/
@WebApiServiceGen
@ProxyGen
public interface BankAccountEnUSGenApiService {
	static void registerService(SiteContextEnUS siteContext, Vertx vertx) {
		new ServiceBinder(vertx).setAddress("enUSBankAccount").register(BankAccountEnUSGenApiService.class, new BankAccountEnUSApiServiceImpl(siteContext));
	}

	static BankAccountEnUSGenApiService create(SiteContextEnUS siteContext, Vertx vertx) {
		return new BankAccountEnUSApiServiceImpl(siteContext);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static BankAccountEnUSGenApiService createProxy(Vertx vertx, String address) {
		return new BankAccountEnUSGenApiServiceVertxEBProxy(vertx, address);
	}

	public void postBankAccount(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void patchBankAccount(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void getBankAccount(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void deleteBankAccount(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchBankAccount(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageBankAccountId(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageBankAccount(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
}

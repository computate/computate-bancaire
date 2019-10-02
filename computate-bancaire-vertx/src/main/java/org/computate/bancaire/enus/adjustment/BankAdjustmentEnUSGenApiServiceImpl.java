package org.computate.bancaire.enus.adjustment;

import org.computate.bancaire.enus.config.SiteConfig;
import org.computate.bancaire.enus.request.SiteRequestEnUS;
import org.computate.bancaire.enus.contexte.SiteContextEnUS;
import org.computate.bancaire.enus.user.SiteUser;
import org.computate.bancaire.enus.search.SearchResult;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.commons.lang3.StringUtils;
import java.security.Principal;
import org.apache.commons.lang3.exception.ExceptionUtils;
import java.io.PrintWriter;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrDocument;
import java.util.Collection;
import java.math.BigDecimal;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Router;
import io.vertx.core.Vertx;
import io.vertx.ext.reactivestreams.ReactiveReadStream;
import io.vertx.ext.reactivestreams.ReactiveWriteStream;
import io.vertx.core.MultiMap;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.api.validation.HTTPRequestValidationHandler;
import io.vertx.ext.web.api.validation.ParameterTypeValidator;
import io.vertx.ext.web.api.validation.ValidationException;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.ext.sql.SQLClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Timestamp;
import io.vertx.core.Future;
import io.vertx.core.http.CaseInsensitiveHeaders;
import io.vertx.core.AsyncResult;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.api.OperationResponse;
import io.vertx.core.CompositeFuture;
import org.apache.http.client.utils.URLEncodedUtils;
import java.nio.charset.Charset;
import org.apache.http.NameValuePair;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.auth.oauth2.KeycloakHelper;
import java.util.Optional;
import java.util.stream.Stream;
import java.net.URLDecoder;
import java.time.ZonedDateTime;
import org.apache.solr.common.util.SimpleOrderedMap;
import org.computate.bancaire.enus.search.SearchList;
import org.computate.bancaire.enus.writer.AllWriter;


/**
 * Translate: false
 **/
public class BankAdjustmentEnUSGenApiServiceImpl implements BankAdjustmentEnUSGenApiService {

	protected static final Logger LOGGER = LoggerFactory.getLogger(BankAdjustmentEnUSGenApiServiceImpl.class);

	protected static final String SERVICE_ADDRESS = "BankAdjustmentEnUSApiServiceImpl";

	protected SiteContextEnUS siteContext;

	public BankAdjustmentEnUSGenApiServiceImpl(SiteContextEnUS siteContext) {
		this.siteContext = siteContext;
		BankAdjustmentEnUSGenApiService service = BankAdjustmentEnUSGenApiService.createProxy(siteContext.getVertx(), SERVICE_ADDRESS);
	}

	// POST //

	@Override
	public void postBankAdjustment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = generateSiteRequestEnUSForBankAdjustment(siteContext, operationRequest, body);
			sqlBankAdjustment(siteRequest, a -> {
				if(a.succeeded()) {
					createPOSTBankAdjustment(siteRequest, b -> {
						if(b.succeeded()) {
							BankAdjustment bankAdjustment = b.result();
							sqlPOSTBankAdjustment(bankAdjustment, c -> {
								if(c.succeeded()) {
									defineBankAdjustment(bankAdjustment, d -> {
										if(d.succeeded()) {
											attributeBankAdjustment(bankAdjustment, e -> {
												if(e.succeeded()) {
													indexBankAdjustment(bankAdjustment, f -> {
														if(f.succeeded()) {
															response200POSTBankAdjustment(bankAdjustment, g -> {
																if(f.succeeded()) {
																	SQLConnection sqlConnection = siteRequest.getSqlConnection();
																	sqlConnection.commit(h -> {
																		if(a.succeeded()) {
																			sqlConnection.close(i -> {
																				if(a.succeeded()) {
																					eventHandler.handle(Future.succeededFuture(g.result()));
																				} else {
																					errorBankAdjustment(siteRequest, eventHandler, i);
																				}
																			});
																		} else {
																			errorBankAdjustment(siteRequest, eventHandler, h);
																		}
																	});
																} else {
																	errorBankAdjustment(siteRequest, eventHandler, g);
																}
															});
														} else {
															errorBankAdjustment(siteRequest, eventHandler, f);
														}
													});
												} else {
													errorBankAdjustment(siteRequest, eventHandler, e);
												}
											});
										} else {
											errorBankAdjustment(siteRequest, eventHandler, d);
										}
									});
								} else {
									errorBankAdjustment(siteRequest, eventHandler, c);
								}
							});
						} else {
							errorBankAdjustment(siteRequest, eventHandler, b);
						}
					});
				} else {
					errorBankAdjustment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception e) {
			errorBankAdjustment(null, eventHandler, Future.failedFuture(e));
		}
	}

	public void createPOSTBankAdjustment(SiteRequestEnUS siteRequest, Handler<AsyncResult<BankAdjustment>> eventHandler) {
		try {
			SQLConnection sqlConnection = siteRequest.getSqlConnection();
			String userId = siteRequest.getUserId();

			sqlConnection.queryWithParams(
					SiteContextEnUS.SQL_create
					, new JsonArray(Arrays.asList(BankAdjustment.class.getCanonicalName(), userId))
					, createAsync
			-> {
				JsonArray createLine = createAsync.result().getResults().stream().findFirst().orElseGet(() -> null);
				Long pk = createLine.getLong(0);
				BankAdjustment o = new BankAdjustment();
				o.setPk(pk);
				o.setSiteRequest_(siteRequest);
				eventHandler.handle(Future.succeededFuture(o));
			});
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void sqlPOSTBankAdjustment(BankAdjustment o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			SQLConnection sqlConnection = siteRequest.getSqlConnection();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			StringBuilder postSql = new StringBuilder();
			List<Object> postSqlParams = new ArrayList<Object>();

			if(jsonObject != null) {
				Set<String> entityVars = jsonObject.fieldNames();
				for(String entityVar : entityVars) {
					switch(entityVar) {
					case "agentAreas":
						postSql.append(SiteContextEnUS.SQL_setD);
						postSqlParams.addAll(Arrays.asList("agentAreas", jsonObject.getJsonArray(entityVar), pk));
						break;
					case "agentRoles":
						postSql.append(SiteContextEnUS.SQL_setD);
						postSqlParams.addAll(Arrays.asList("agentRoles", jsonObject.getJsonArray(entityVar), pk));
						break;
					case "agentOverride":
						postSql.append(SiteContextEnUS.SQL_setD);
						postSqlParams.addAll(Arrays.asList("agentOverride", jsonObject.getBoolean(entityVar), pk));
						break;
					case "eligibleEntitlement":
						postSql.append(SiteContextEnUS.SQL_setD);
						postSqlParams.addAll(Arrays.asList("eligibleEntitlement", jsonObject.getBoolean(entityVar), pk));
						break;
					case "partnerName":
						postSql.append(SiteContextEnUS.SQL_setD);
						postSqlParams.addAll(Arrays.asList("partnerName", jsonObject.getString(entityVar), pk));
						break;
					case "adjustmentDisplayName":
						postSql.append(SiteContextEnUS.SQL_setD);
						postSqlParams.addAll(Arrays.asList("adjustmentDisplayName", jsonObject.getString(entityVar), pk));
						break;
					}
				}
			}
			sqlConnection.queryWithParams(
					postSql.toString()
					, new JsonArray(postSqlParams)
					, postAsync
			-> {
				if(postAsync.succeeded()) {
					eventHandler.handle(Future.succeededFuture());
				} else {
					eventHandler.handle(Future.failedFuture(new Exception(postAsync.cause())));
				}
			});
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void response200POSTBankAdjustment(BankAdjustment o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			JsonObject json = new JsonObject();
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(json)));
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// PATCH //

	@Override
	public void patchBankAdjustment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = generateSiteRequestEnUSForBankAdjustment(siteContext, operationRequest, body);
			sqlBankAdjustment(siteRequest, a -> {
				if(a.succeeded()) {
					userBankAdjustment(siteRequest, b -> {
						if(b.succeeded()) {
							aSearchBankAdjustment(siteRequest, false, true, null, c -> {
								if(c.succeeded()) {
									SearchList<BankAdjustment> listBankAdjustment = c.result();
									SimpleOrderedMap facets = (SimpleOrderedMap)listBankAdjustment.getQueryResponse().getResponse().get("facets");
									Date date = (Date)facets.get("max_modified");
									String dateStr;
									if(date == null)
										dateStr = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(ZonedDateTime.now().toInstant(), ZoneId.of("UTC")).minusNanos(1000));
									else
										dateStr = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC")));
									listPATCHBankAdjustment(listBankAdjustment, dateStr, d -> {
										if(d.succeeded()) {
											SQLConnection sqlConnection = siteRequest.getSqlConnection();
											if(sqlConnection == null) {
												eventHandler.handle(Future.succeededFuture(d.result()));
											} else {
												sqlConnection.commit(e -> {
													if(e.succeeded()) {
														sqlConnection.close(f -> {
															if(f.succeeded()) {
																eventHandler.handle(Future.succeededFuture(d.result()));
															} else {
																errorBankAdjustment(siteRequest, eventHandler, f);
															}
														});
													} else {
														eventHandler.handle(Future.succeededFuture(d.result()));
													}
												});
											}
										} else {
											errorBankAdjustment(siteRequest, eventHandler, d);
										}
									});
								} else {
									errorBankAdjustment(siteRequest, eventHandler, c);
								}
							});
						} else {
							errorBankAdjustment(siteRequest, eventHandler, b);
						}
					});
				} else {
					errorBankAdjustment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception e) {
			errorBankAdjustment(null, eventHandler, Future.failedFuture(e));
		}
	}

	public void listPATCHBankAdjustment(SearchList<BankAdjustment> listBankAdjustment, String dt, Handler<AsyncResult<OperationResponse>> eventHandler) {
		List<Future> futures = new ArrayList<>();
		SiteRequestEnUS siteRequest = listBankAdjustment.getSiteRequest_();
		listBankAdjustment.getList().forEach(o -> {
			futures.add(
				futurePATCHBankAdjustment(o, a -> {
					if(a.succeeded()) {
					} else {
						errorBankAdjustment(siteRequest, eventHandler, a);
					}
				})
			);
		});
		CompositeFuture.all(futures).setHandler( a -> {
			if(a.succeeded()) {
				if(listBankAdjustment.next(dt)) {
					listPATCHBankAdjustment(listBankAdjustment, dt, eventHandler);
				} else {
					response200PATCHBankAdjustment(listBankAdjustment, eventHandler);
				}
			} else {
				errorBankAdjustment(listBankAdjustment.getSiteRequest_(), eventHandler, a);
			}
		});
	}

	public Future<BankAdjustment> futurePATCHBankAdjustment(BankAdjustment o,  Handler<AsyncResult<OperationResponse>> eventHandler) {
		Future<BankAdjustment> future = Future.future();
		try {
			sqlPATCHBankAdjustment(o, a -> {
				if(a.succeeded()) {
					BankAdjustment bankAdjustment = a.result();
					defineBankAdjustment(bankAdjustment, b -> {
						if(b.succeeded()) {
							attributeBankAdjustment(bankAdjustment, c -> {
								if(c.succeeded()) {
									indexBankAdjustment(bankAdjustment, d -> {
										if(d.succeeded()) {
											future.complete(o);
											eventHandler.handle(Future.succeededFuture(d.result()));
										} else {
											eventHandler.handle(Future.failedFuture(d.cause()));
										}
									});
								} else {
									eventHandler.handle(Future.failedFuture(c.cause()));
								}
							});
						} else {
							eventHandler.handle(Future.failedFuture(b.cause()));
						}
					});
				} else {
					eventHandler.handle(Future.failedFuture(a.cause()));
				}
			});
			return future;
		} catch(Exception e) {
			return Future.failedFuture(e);
		}
	}

	public void sqlPATCHBankAdjustment(BankAdjustment o, Handler<AsyncResult<BankAdjustment>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			SQLConnection sqlConnection = siteRequest.getSqlConnection();
			Long pk = o.getPk();
			JsonObject requestJson = siteRequest.getJsonObject();
			StringBuilder patchSql = new StringBuilder();
			List<Object> patchSqlParams = new ArrayList<Object>();
			Set<String> methodNames = requestJson.fieldNames();
			BankAdjustment o2 = new BankAdjustment();

			patchSql.append(SiteContextEnUS.SQL_modify);
			patchSqlParams.addAll(Arrays.asList(pk, "org.computate.bancaire.enus.adjustment.BankAdjustment"));
			for(String methodName : methodNames) {
				switch(methodName) {
					case "setCreated":
						o2.setCreated(requestJson.getString(methodName));
						if(o2.getCreated() == null) {
							patchSql.append(SiteContextEnUS.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "created"));
						} else {
							patchSql.append(SiteContextEnUS.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("created", o2.jsonCreated(), pk));
						}
						break;
					case "setModified":
						o2.setModified(requestJson.getString(methodName));
						if(o2.getModified() == null) {
							patchSql.append(SiteContextEnUS.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "modified"));
						} else {
							patchSql.append(SiteContextEnUS.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("modified", o2.jsonModified(), pk));
						}
						break;
					case "setArchived":
						o2.setArchived(requestJson.getBoolean(methodName));
						if(o2.getArchived() == null) {
							patchSql.append(SiteContextEnUS.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "archived"));
						} else {
							patchSql.append(SiteContextEnUS.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("archived", o2.jsonArchived(), pk));
						}
						break;
					case "setDeleted":
						o2.setDeleted(requestJson.getBoolean(methodName));
						if(o2.getDeleted() == null) {
							patchSql.append(SiteContextEnUS.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "deleted"));
						} else {
							patchSql.append(SiteContextEnUS.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("deleted", o2.jsonDeleted(), pk));
						}
						break;
					case "addAgentAreas":
						requestJson.getJsonArray(methodName).forEach((v) -> {
							o2.addAgentAreas((String)v);
							patchSql.append(SiteContextEnUS.SQL_addA);
							patchSqlParams.addAll(Arrays.asList("agentAreas", o2.getAgentAreas(), pk));
						});
					case "setAgentAreas":
						o2.getAgentAreas().clear();
						requestJson.getJsonArray(methodName).forEach((v) -> {
							o2.addAgentAreas((String)v);
							patchSql.append(SiteContextEnUS.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("agentAreas", o2.jsonAgentAreas(), pk));
						});
						break;
					case "addAgentRoles":
						requestJson.getJsonArray(methodName).forEach((v) -> {
							o2.addAgentRoles((String)v);
							patchSql.append(SiteContextEnUS.SQL_addA);
							patchSqlParams.addAll(Arrays.asList("agentRoles", o2.getAgentRoles(), pk));
						});
					case "setAgentRoles":
						o2.getAgentRoles().clear();
						requestJson.getJsonArray(methodName).forEach((v) -> {
							o2.addAgentRoles((String)v);
							patchSql.append(SiteContextEnUS.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("agentRoles", o2.jsonAgentRoles(), pk));
						});
						break;
					case "setAgentOverride":
						o2.setAgentOverride(requestJson.getBoolean(methodName));
						if(o2.getAgentOverride() == null) {
							patchSql.append(SiteContextEnUS.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "agentOverride"));
						} else {
							patchSql.append(SiteContextEnUS.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("agentOverride", o2.jsonAgentOverride(), pk));
						}
						break;
					case "setEligibleEntitlement":
						o2.setEligibleEntitlement(requestJson.getBoolean(methodName));
						if(o2.getEligibleEntitlement() == null) {
							patchSql.append(SiteContextEnUS.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "eligibleEntitlement"));
						} else {
							patchSql.append(SiteContextEnUS.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("eligibleEntitlement", o2.jsonEligibleEntitlement(), pk));
						}
						break;
					case "setPartnerName":
						o2.setPartnerName(requestJson.getString(methodName));
						if(o2.getPartnerName() == null) {
							patchSql.append(SiteContextEnUS.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "partnerName"));
						} else {
							patchSql.append(SiteContextEnUS.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("partnerName", o2.jsonPartnerName(), pk));
						}
						break;
					case "setAdjustmentDisplayName":
						o2.setAdjustmentDisplayName(requestJson.getString(methodName));
						if(o2.getAdjustmentDisplayName() == null) {
							patchSql.append(SiteContextEnUS.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "adjustmentDisplayName"));
						} else {
							patchSql.append(SiteContextEnUS.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("adjustmentDisplayName", o2.jsonAdjustmentDisplayName(), pk));
						}
						break;
				}
			}
			sqlConnection.queryWithParams(
					patchSql.toString()
					, new JsonArray(patchSqlParams)
					, patchAsync
			-> {
				if(patchAsync.succeeded()) {
					BankAdjustment o3 = new BankAdjustment();
					o3.setSiteRequest_(o.getSiteRequest_());
					o3.setPk(pk);
					eventHandler.handle(Future.succeededFuture(o3));
				} else {
					eventHandler.handle(Future.failedFuture(new Exception(patchAsync.cause())));
				}
			});
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void response200PATCHBankAdjustment(SearchList<BankAdjustment> listBankAdjustment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = listBankAdjustment.getSiteRequest_();
			JsonObject json = new JsonObject();
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(json)));
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// GET //

	@Override
	public void getBankAdjustment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = generateSiteRequestEnUSForBankAdjustment(siteContext, operationRequest);
			aSearchBankAdjustment(siteRequest, false, true, null, a -> {
				if(a.succeeded()) {
					SearchList<BankAdjustment> listBankAdjustment = a.result();
					response200GETBankAdjustment(listBankAdjustment, b -> {
						if(b.succeeded()) {
							eventHandler.handle(Future.succeededFuture(b.result()));
						} else {
							errorBankAdjustment(siteRequest, eventHandler, b);
						}
					});
				} else {
					errorBankAdjustment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception e) {
			errorBankAdjustment(null, eventHandler, Future.failedFuture(e));
		}
	}

	public void response200GETBankAdjustment(SearchList<BankAdjustment> listBankAdjustment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = listBankAdjustment.getSiteRequest_();
			SolrDocumentList solrDocuments = listBankAdjustment.getSolrDocumentList();

			JsonObject json = JsonObject.mapFrom(listBankAdjustment.get(0));
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(json)));
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// DELETE //

	@Override
	public void deleteBankAdjustment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = generateSiteRequestEnUSForBankAdjustment(siteContext, operationRequest);
			sqlBankAdjustment(siteRequest, a -> {
				if(a.succeeded()) {
					aSearchBankAdjustment(siteRequest, false, true, null, b -> {
						if(b.succeeded()) {
							SearchList<BankAdjustment> listBankAdjustment = b.result();
							deleteDELETEBankAdjustment(siteRequest, c -> {
								if(c.succeeded()) {
									response200DELETEBankAdjustment(siteRequest, d -> {
										if(d.succeeded()) {
											SQLConnection sqlConnection = siteRequest.getSqlConnection();
											if(sqlConnection == null) {
												eventHandler.handle(Future.succeededFuture(d.result()));
											} else {
												sqlConnection.commit(e -> {
													if(e.succeeded()) {
														sqlConnection.close(f -> {
															if(f.succeeded()) {
																eventHandler.handle(Future.succeededFuture(d.result()));
															} else {
																errorBankAdjustment(siteRequest, eventHandler, f);
															}
														});
													} else {
														eventHandler.handle(Future.succeededFuture(d.result()));
													}
												});
											}
										} else {
											errorBankAdjustment(siteRequest, eventHandler, d);
										}
									});
								} else {
									errorBankAdjustment(siteRequest, eventHandler, c);
								}
							});
						} else {
							errorBankAdjustment(siteRequest, eventHandler, b);
						}
					});
				} else {
					errorBankAdjustment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception e) {
			errorBankAdjustment(null, eventHandler, Future.failedFuture(e));
		}
	}

	public void deleteDELETEBankAdjustment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SQLConnection sqlConnection = siteRequest.getSqlConnection();
			String userId = siteRequest.getUserId();
			Long pk = siteRequest.getRequestPk();

			sqlConnection.queryWithParams(
					SiteContextEnUS.SQL_delete
					, new JsonArray(Arrays.asList(pk, BankAdjustment.class.getCanonicalName(), pk, pk, pk, pk))
					, deleteAsync
			-> {
				eventHandler.handle(Future.succeededFuture());
			});
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void response200DELETEBankAdjustment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			JsonObject json = new JsonObject();
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(json)));
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// Search //

	@Override
	public void searchBankAdjustment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = generateSiteRequestEnUSForBankAdjustment(siteContext, operationRequest);
			aSearchBankAdjustment(siteRequest, false, true, null, a -> {
				if(a.succeeded()) {
					SearchList<BankAdjustment> listBankAdjustment = a.result();
					response200SearchBankAdjustment(listBankAdjustment, b -> {
						if(b.succeeded()) {
							eventHandler.handle(Future.succeededFuture(b.result()));
						} else {
							errorBankAdjustment(siteRequest, eventHandler, b);
						}
					});
				} else {
					errorBankAdjustment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception e) {
			errorBankAdjustment(null, eventHandler, Future.failedFuture(e));
		}
	}

	public void response200SearchBankAdjustment(SearchList<BankAdjustment> listBankAdjustment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = listBankAdjustment.getSiteRequest_();
			QueryResponse responseSearch = listBankAdjustment.getQueryResponse();
			SolrDocumentList solrDocuments = listBankAdjustment.getSolrDocumentList();
			Long searchInMillis = Long.valueOf(responseSearch.getQTime());
			Long transmissionInMillis = responseSearch.getElapsedTime();
			Long startNum = responseSearch.getResults().getStart();
			Long foundNum = responseSearch.getResults().getNumFound();
			Integer returnedNum = responseSearch.getResults().size();
			String searchTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(searchInMillis), TimeUnit.MILLISECONDS.toMillis(searchInMillis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(searchInMillis)));
			String transmissionTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis), TimeUnit.MILLISECONDS.toMillis(transmissionInMillis) - TimeUnit.SECONDS.toSeconds(TimeUnit.MILLISECONDS.toSeconds(transmissionInMillis)));
			Exception exceptionSearch = responseSearch.getException();

			JsonObject json = new JsonObject();
			json.put("startNum", startNum);
			json.put("foundNum", foundNum);
			json.put("returnedNum", returnedNum);
			json.put("searchTime", searchTime);
			json.put("transmissionTime", transmissionTime);
			JsonArray l = new JsonArray();
			listBankAdjustment.getList().stream().forEach(o -> {
				JsonObject json2 = JsonObject.mapFrom(o);
				List<String> fls = listBankAdjustment.getFields();
				if(fls.size() > 0) {
					Set<String> fieldNames = new HashSet<String>();
					fieldNames.addAll(json2.fieldNames());
					for(String fieldName : fieldNames) {
						if(!fls.contains(fieldName))
							json2.remove(fieldName);
					}
				}
				l.add(json2);
			});
			json.put("list", l);
			if(exceptionSearch != null) {
				json.put("exceptionSearch", exceptionSearch.getMessage());
			}
			eventHandler.handle(Future.succeededFuture(OperationResponse.completedWithJson(json)));
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	// SearchPage //

	@Override
	public void searchpageBankAdjustmentId(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		searchpageBankAdjustment(operationRequest, eventHandler);
	}

	@Override
	public void searchpageBankAdjustment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = generateSiteRequestEnUSForBankAdjustment(siteContext, operationRequest);
			sqlBankAdjustment(siteRequest, a -> {
				if(a.succeeded()) {
					userBankAdjustment(siteRequest, b -> {
						if(b.succeeded()) {
							aSearchBankAdjustment(siteRequest, false, true, "/ajustement", c -> {
								if(c.succeeded()) {
									SearchList<BankAdjustment> listBankAdjustment = c.result();
									response200SearchPageBankAdjustment(listBankAdjustment, d -> {
										if(d.succeeded()) {
											SQLConnection sqlConnection = siteRequest.getSqlConnection();
											if(sqlConnection == null) {
												eventHandler.handle(Future.succeededFuture(d.result()));
											} else {
												sqlConnection.commit(e -> {
													if(e.succeeded()) {
														sqlConnection.close(f -> {
															if(f.succeeded()) {
																eventHandler.handle(Future.succeededFuture(d.result()));
															} else {
																errorBankAdjustment(siteRequest, eventHandler, f);
															}
														});
													} else {
														eventHandler.handle(Future.succeededFuture(d.result()));
													}
												});
											}
										} else {
											errorBankAdjustment(siteRequest, eventHandler, d);
										}
									});
								} else {
									errorBankAdjustment(siteRequest, eventHandler, c);
								}
							});
						} else {
							errorBankAdjustment(siteRequest, eventHandler, b);
						}
					});
				} else {
					errorBankAdjustment(siteRequest, eventHandler, a);
				}
			});
		} catch(Exception e) {
			errorBankAdjustment(null, eventHandler, Future.failedFuture(e));
		}
	}

	public void response200SearchPageBankAdjustment(SearchList<BankAdjustment> listBankAdjustment, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = listBankAdjustment.getSiteRequest_();
			Buffer buffer = Buffer.buffer();
			AllWriter w = AllWriter.create(listBankAdjustment.getSiteRequest_(), buffer);
			AdjustmentPage page = new AdjustmentPage();
			SolrDocument pageSolrDocument = new SolrDocument();

			pageSolrDocument.setField("pageUri_frFR_stored_string", "/ajustement");
			page.setPageSolrDocument(pageSolrDocument);
			page.setW(w);
			page.setListBankAdjustment(listBankAdjustment);
			page.initDeepAdjustmentPage(siteRequest);
			page.html();
			eventHandler.handle(Future.succeededFuture(new OperationResponse(200, "OK", buffer, new CaseInsensitiveHeaders())));
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public String varIndexedBankAdjustment(String entityVar) {
		switch(entityVar) {
			case "pk":
				return "pk_indexed_long";
			case "id":
				return "id_indexed_string";
			case "created":
				return "created_indexed_date";
			case "modified":
				return "modified_indexed_date";
			case "archived":
				return "archived_indexed_boolean";
			case "deleted":
				return "deleted_indexed_boolean";
			case "classCanonicalName":
				return "classCanonicalName_indexed_string";
			case "classSimpleName":
				return "classSimpleName_indexed_string";
			case "classCanonicalNames":
				return "classCanonicalNames_indexed_strings";
			case "adjustmentKey":
				return "adjustmentKey_indexed_long";
			case "accountKey":
				return "accountKey_indexed_long";
			case "accountCompleteName":
				return "accountCompleteName_indexed_string";
			case "accountNumber":
				return "accountNumber_indexed_string";
			case "transactionKey":
				return "transactionKey_indexed_long";
			case "transactionReferenceId":
				return "transactionReferenceId_indexed_string";
			case "transactionCode":
				return "transactionCode_indexed_string";
			case "transactionAmount":
				return "transactionAmount_indexed_double";
			case "transactionDateTime":
				return "transactionDateTime_indexed_date";
			case "transactionDate":
				return "transactionDate_indexed_date";
			case "transactionFee":
				return "transactionFee_indexed_boolean";
			case "agentAreas":
				return "agentAreas_indexed_strings";
			case "agentRoles":
				return "agentRoles_indexed_strings";
			case "agentOverride":
				return "agentOverride_indexed_boolean";
			case "eligibleEntitlement":
				return "eligibleEntitlement_indexed_boolean";
			case "partnerName":
				return "partnerName_indexed_string";
			case "adjustmentDisplayName":
				return "adjustmentDisplayName_indexed_string";
			case "adjustmentCompleteName":
				return "adjustmentCompleteName_indexed_string";
			case "adjustmentId":
				return "adjustmentId_indexed_string";
			case "pageUrl":
				return "pageUrl_indexed_string";
			case "objectSuggest":
				return "objectSuggest_indexed_string";
			default:
				throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		}
	}

	public String varSearchBankAdjustment(String entityVar) {
		switch(entityVar) {
			case "objectSuggest":
				return "objectSuggest_suggested";
			default:
				throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		}
	}

	public String varSuggereBankAdjustment(String entityVar) {
		switch(entityVar) {
			case "objectSuggest":
				return "objectSuggest_suggested";
			default:
				throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		}
	}

	// Partagé //

	public void errorBankAdjustment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler, AsyncResult<?> resultAsync) {
		Throwable e = resultAsync.cause();
		ExceptionUtils.printRootCauseStackTrace(e);
		OperationResponse responseOperation = new OperationResponse(400, "BAD REQUEST", 
			Buffer.buffer().appendString(
				new JsonObject() {{
					put("error", new JsonObject() {{
					put("message", e.getMessage());
					}});
				}}.encodePrettily()
			)
			, new CaseInsensitiveHeaders()
		);
		if(siteRequest != null) {
			SQLConnection sqlConnection = siteRequest.getSqlConnection();
			if(sqlConnection != null) {
				sqlConnection.rollback(a -> {
					if(a.succeeded()) {
						sqlConnection.close(b -> {
							if(a.succeeded()) {
								eventHandler.handle(Future.succeededFuture(responseOperation));
							} else {
								eventHandler.handle(Future.succeededFuture(responseOperation));
							}
						});
					} else {
						eventHandler.handle(Future.succeededFuture(responseOperation));
					}
				});
			} else {
				eventHandler.handle(Future.succeededFuture(responseOperation));
			}
		} else {
			eventHandler.handle(Future.succeededFuture(responseOperation));
		}
	}

	public void sqlBankAdjustment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SQLClient sqlClient = siteRequest.getSiteContext_().getSqlClient();

			if(sqlClient == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				sqlClient.getConnection(sqlAsync -> {
					if(sqlAsync.succeeded()) {
						SQLConnection sqlConnection = sqlAsync.result();
						sqlConnection.setAutoCommit(false, a -> {
							if(a.succeeded()) {
								siteRequest.setSqlConnection(sqlConnection);
								eventHandler.handle(Future.succeededFuture());
							} else {
								eventHandler.handle(Future.failedFuture(a.cause()));
							}
						});
					} else {
						eventHandler.handle(Future.failedFuture(new Exception(sqlAsync.cause())));
					}
				});
			}
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public SiteRequestEnUS generateSiteRequestEnUSForBankAdjustment(SiteContextEnUS siteContext, OperationRequest operationRequest) {
		return generateSiteRequestEnUSForBankAdjustment(siteContext, operationRequest, null);
	}

	public SiteRequestEnUS generateSiteRequestEnUSForBankAdjustment(SiteContextEnUS siteContext, OperationRequest operationRequest, JsonObject body) {
		Vertx vertx = siteContext.getVertx();
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
		siteRequest.setJsonObject(body);
		siteRequest.setVertx(vertx);
		siteRequest.setSiteContext_(siteContext);
		siteRequest.setSiteConfig_(siteContext.getSiteConfig());
		siteRequest.setOperationRequest(operationRequest);
		siteRequest.initDeepSiteRequestEnUS(siteRequest);

		return siteRequest;
	}

	public void userBankAdjustment(SiteRequestEnUS siteRequest, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SQLConnection sqlConnection = siteRequest.getSqlConnection();
			String userId = siteRequest.getUserId();
			if(userId == null) {
				eventHandler.handle(Future.succeededFuture());
			} else {
				sqlConnection.queryWithParams(
						SiteContextEnUS.SQL_selectC
						, new JsonArray(Arrays.asList("org.computate.bancaire.enus.user.SiteUser", userId))
						, selectCAsync
				-> {
					if(selectCAsync.succeeded()) {
						JsonArray userValues = selectCAsync.result().getResults().stream().findFirst().orElse(null);
						if(userValues == null) {
							sqlConnection.queryWithParams(
									SiteContextEnUS.SQL_create
									, new JsonArray(Arrays.asList("org.computate.bancaire.enus.user.SiteUser", userId))
									, createAsync
							-> {
								JsonArray createLine = createAsync.result().getResults().stream().findFirst().orElseGet(() -> null);
								Long pkUser = createLine.getLong(0);
								SiteUser siteUser = new SiteUser();
								siteUser.setPk(pkUser);

								sqlConnection.queryWithParams(
										SiteContextEnUS.SQL_define
										, new JsonArray(Arrays.asList(pkUser, pkUser, pkUser))
										, defineAsync
								-> {
									if(defineAsync.succeeded()) {
										try {
											for(JsonArray definition : defineAsync.result().getResults()) {
												siteUser.defineForClass(definition.getString(0), definition.getString(1));
											}
											JsonObject userVertx = siteRequest.getOperationRequest().getUser();
											JsonObject jsonPrincipal = KeycloakHelper.parseToken(userVertx.getString("access_token"));
											siteUser.setUserName(jsonPrincipal.getString("preferred_username"));
											siteUser.setUserFirstName(jsonPrincipal.getString("given_name"));
											siteUser.setUserLastName(jsonPrincipal.getString("family_name"));
											siteUser.setUserId(jsonPrincipal.getString("sub"));
											siteUser.initDeepForClass(siteRequest);
											siteUser.indexForClass();
											siteRequest.setSiteUser(siteUser);
											siteRequest.setUserName(jsonPrincipal.getString("preferred_username"));
											siteRequest.setUserFirstName(jsonPrincipal.getString("given_name"));
											siteRequest.setUserLastName(jsonPrincipal.getString("family_name"));
											siteRequest.setUserId(jsonPrincipal.getString("sub"));
											eventHandler.handle(Future.succeededFuture());
										} catch(Exception e) {
											eventHandler.handle(Future.failedFuture(e));
										}
									} else {
										eventHandler.handle(Future.failedFuture(new Exception(defineAsync.cause())));
									}
								});
							});
						} else {
							Long pkUser = userValues.getLong(0);
							SiteUser siteUser = new SiteUser();
							siteUser.setPk(pkUser);

							sqlConnection.queryWithParams(
									SiteContextEnUS.SQL_define
									, new JsonArray(Arrays.asList(pkUser, pkUser, pkUser))
									, defineAsync
							-> {
								if(defineAsync.succeeded()) {
									for(JsonArray definition : defineAsync.result().getResults()) {
										siteUser.defineForClass(definition.getString(0), definition.getString(1));
									}
									JsonObject userVertx = siteRequest.getOperationRequest().getUser();
									JsonObject jsonPrincipal = KeycloakHelper.parseToken(userVertx.getString("access_token"));
									siteUser.setUserName(jsonPrincipal.getString("preferred_username"));
									siteUser.setUserFirstName(jsonPrincipal.getString("given_name"));
									siteUser.setUserLastName(jsonPrincipal.getString("family_name"));
									siteUser.setUserId(jsonPrincipal.getString("sub"));
									siteUser.initDeepForClass(siteRequest);
									siteUser.indexForClass();
									siteRequest.setSiteUser(siteUser);
									siteRequest.setUserName(jsonPrincipal.getString("preferred_username"));
									siteRequest.setUserFirstName(jsonPrincipal.getString("given_name"));
									siteRequest.setUserLastName(jsonPrincipal.getString("family_name"));
									siteRequest.setUserId(jsonPrincipal.getString("sub"));
									eventHandler.handle(Future.succeededFuture());
								} else {
									eventHandler.handle(Future.failedFuture(new Exception(defineAsync.cause())));
								}
							});
						}
					} else {
						eventHandler.handle(Future.failedFuture(new Exception(selectCAsync.cause())));
					}
				});
			}
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void aSearchBankAdjustment(SiteRequestEnUS siteRequest, Boolean populate, Boolean store, String classApiUriMethod, Handler<AsyncResult<SearchList<BankAdjustment>>> eventHandler) {
		try {
			OperationRequest operationRequest = siteRequest.getOperationRequest();
			String entityListStr = siteRequest.getOperationRequest().getParams().getJsonObject("query").getString("fl");
			String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
			SearchList<BankAdjustment> listSearch = new SearchList<BankAdjustment>();
			listSearch.setPopulate(populate);
			listSearch.setStore(store);
			listSearch.setQuery("*:*");
			listSearch.setC(BankAdjustment.class);
			if(entityList != null)
				listSearch.addFields(entityList);
			listSearch.addSort("archived_indexed_boolean", ORDER.asc);
			listSearch.addSort("deleted_indexed_boolean", ORDER.asc);
			listSearch.addSort("created_indexed_date", ORDER.desc);
			listSearch.addFilterQuery("classCanonicalNames_indexed_strings:" + ClientUtils.escapeQueryChars("org.computate.bancaire.enus.adjustment.BankAdjustment"));
			listSearch.set("json.facet", "{max_modified:'max(modified_indexed_date)'}");
			SiteUser siteUser = siteRequest.getSiteUser();
			if(siteUser != null && !siteUser.getSeeDeleted())
				listSearch.addFilterQuery("deleted_indexed_boolean:false");
			if(siteUser != null && !siteUser.getSeeArchived())
				listSearch.addFilterQuery("archived_indexed_boolean:false");

			String id = operationRequest.getParams().getJsonObject("path").getString("id");
			if(id != null) {
				listSearch.addFilterQuery("(id:" + ClientUtils.escapeQueryChars(id) + " OR adjustmentId_indexed_string:" + ClientUtils.escapeQueryChars(id) + ")");
			}

			operationRequest.getParams().getJsonObject("query").forEach(paramRequest -> {
				String entityVar = null;
				String valueIndexed = null;
				String varIndexed = null;
				String valueSort = null;
				Integer aSearchStart = null;
				Integer aSearchNum = null;
				String paramName = paramRequest.getKey();
				Object paramValuesObject = paramRequest.getValue();
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					for(Object paramObject : paramObjects) {
						switch(paramName) {
							case "q":
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								varIndexed = "*".equals(entityVar) ? entityVar : varSearchBankAdjustment(entityVar);
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								valueIndexed = StringUtils.isEmpty(valueIndexed) ? "*" : valueIndexed;
								listSearch.setQuery(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : ClientUtils.escapeQueryChars(valueIndexed)));
								if(!"*".equals(entityVar)) {
									listSearch.setHighlight(true);
									listSearch.setHighlightSnippets(3);
									listSearch.addHighlightField(varIndexed);
									listSearch.setParam("hl.encoder", "html");
								}
								break;
							case "fq":
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								varIndexed = varIndexedBankAdjustment(entityVar);
								listSearch.addFilterQuery(varIndexed + ":" + ClientUtils.escapeQueryChars(valueIndexed));
								break;
							case "sort":
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
								valueSort = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
								varIndexed = varIndexedBankAdjustment(entityVar);
								listSearch.addSort(varIndexed, ORDER.valueOf(valueSort));
								break;
							case "start":
								aSearchStart = (Integer)paramObject;
								listSearch.setStart(aSearchStart);
								break;
							case "rows":
								aSearchNum = (Integer)paramObject;
								listSearch.setRows(aSearchNum);
								break;
						}
					}
				} catch(Exception e) {
					eventHandler.handle(Future.failedFuture(e));
				}
			});
			listSearch.initDeepForClass(siteRequest);
			eventHandler.handle(Future.succeededFuture(listSearch));
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void defineBankAdjustment(BankAdjustment o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			SQLConnection sqlConnection = siteRequest.getSqlConnection();
			Long pk = o.getPk();
			sqlConnection.queryWithParams(
					SiteContextEnUS.SQL_define
					, new JsonArray(Arrays.asList(pk, pk, pk))
					, defineAsync
			-> {
				if(defineAsync.succeeded()) {
					try {
						for(JsonArray definition : defineAsync.result().getResults()) {
							o.defineForClass(definition.getString(0), definition.getString(1));
						}
						eventHandler.handle(Future.succeededFuture());
					} catch(Exception e) {
						eventHandler.handle(Future.failedFuture(e));
					}
				} else {
					eventHandler.handle(Future.failedFuture(new Exception(defineAsync.cause())));
				}
			});
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void attributeBankAdjustment(BankAdjustment o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			SQLConnection sqlConnection = siteRequest.getSqlConnection();
			Long pk = o.getPk();
			sqlConnection.queryWithParams(
					SiteContextEnUS.SQL_attribute
					, new JsonArray(Arrays.asList(pk, pk))
					, attributeAsync
			-> {
				try {
					if(attributeAsync.succeeded()) {
						if(attributeAsync.result() != null) {
							for(JsonArray definition : attributeAsync.result().getResults()) {
								if(pk.equals(definition.getLong(0)))
									o.attributeForClass(definition.getString(2), definition.getLong(1));
								else
									o.attributeForClass(definition.getString(3), definition.getLong(0));
							}
						}
						eventHandler.handle(Future.succeededFuture());
					} else {
						eventHandler.handle(Future.failedFuture(new Exception(attributeAsync.cause())));
					}
				} catch(Exception e) {
					eventHandler.handle(Future.failedFuture(e));
				}
			});
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}

	public void indexBankAdjustment(BankAdjustment o, Handler<AsyncResult<OperationResponse>> eventHandler) {
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		try {
			o.initDeepForClass(siteRequest);
			o.indexForClass();
			eventHandler.handle(Future.succeededFuture());
		} catch(Exception e) {
			eventHandler.handle(Future.failedFuture(e));
		}
	}
}

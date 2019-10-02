package org.computate.bancaire.frfr.transaction.code;

import java.text.Normalizer;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.frfr.cluster.Cluster;
import org.computate.bancaire.frfr.couverture.Couverture;


/**                                   
 * NomCanonique.enUS: org.computate.bancaire.enus.transaction.code.TransactionCode
 * Modele: true
 * Api: true
 * Indexe: true
 * Sauvegarde: true
 * 
 * ApiTag.frFR: Compte
 * ApiUri.frFR: /api/code-transaction
 * 
 * ApiTag.enUS: Account
 * ApiUri.enUS: /api/transaction-code
 * 
 * ApiMethode: POST
 * ApiMethode: PATCH
 * ApiMethode: GET
 * ApiMethode: DELETE
 * ApiMethode.frFR: Recherche
 * ApiMethode.enUS: Search
 * 
 * ApiMethode.frFR: PageRecherche
 * PagePageRecherche.frFR: CodeTransactionPage
 * PageSuperPageRecherche.frFR: ClusterPage
 * ApiUriPageRecherche.frFR: /code-transaction
 * 
 * ApiMethode.enUS: SearchPage
 * PageSearchPage.enUS: CodeTransactionPage
 * PageSuperSearchPage.enUS: ClusterPage
 * ApiUriSearchPage.enUS: /transaction-code
 * 
 * UnNom.frFR: un code de transaction
 * UnNom.enUS: a transaction code
 * Adectif.frFR: bancaire
 * Adjectif.enUS: bank
 * Couleur: yellow
 * IconeGroupe: duotone
 * IconeNom: code-commit
 */                  
public class CodeTransaction extends CodeTransactionGen<Cluster> {

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionCodeKey
	 * Indexe: true
	 * Stocke: true
	 * NomAffichage.frFR: clé
	 * NomAffichage.enUS: key
	 */         
	protected void _codeTransactionCle(Couverture<Long> c) {
		c.o(pk);
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionCode
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 3
	 * HtmlCelulle: 1
	 * NomAffichage.frFR: code de transaction
	 * NomAffichage.enUS: transaction code
	 */                   
	protected void _transactionCode(Couverture<String> c) {}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionCodeDisplayName
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 3
	 * HtmlCelulle: 2
	 * NomAffichage.frFR: nom d'affichage
	 * NomAffichage.enUS: display name
	 */                   
	protected void _codeTransactionNomAffichage(Couverture<String> c) {}

	/**   
	 * {@inheritDoc}
	 * Var.enUS: transactionCodeCompleteName
	 * Indexe: true
	 * Stocke: true
	 * VarTitre: true
	 * HtmlColonne: 1
	 * r: "code de transaction"
	 * r.enUS: "transaction code"
	 * r: codeTransactionNomAffichage
	 * r.enUS: transactionCodeDisplayName
	 */                  
	protected void _codeTransactionNomComplet(Couverture<String> c) {
		String o = "code de transaction";

		if(transactionCode != null && codeTransactionNomAffichage != null)
			o = String.format("%s %s", transactionCode, codeTransactionNomAffichage);
		else if(transactionCode != null)
			o = String.format("%s", transactionCode);
		else if(codeTransactionNomAffichage != null)
			o = String.format("%s", codeTransactionNomAffichage);

		c.o(o);
	}

	/**   
	 * {@inheritDoc}
	 * Var.enUS: transactionCodeId
	 * Indexe: true
	 * Stocke: true
	 * VarId: true
	 * HtmlLigne: 1
	 * HtmlCelulle: 4
	 * Description.frFR: 
	 * Description.enUS: 
	 * NomAffichage.frFR: ID
	 * NomAffichage.enUS: ID
	 * r: codeTransactionNomComplet
	 * r.enUS: transactionCodeCompleteName
	 */            
	protected void _codeTransactionId(Couverture<String> c) {
		if(codeTransactionNomComplet != null) {
			String s = Normalizer.normalize(codeTransactionNomComplet, Normalizer.Form.NFD);
			s = StringUtils.lowerCase(s);
			s = StringUtils.trim(s);
			s = StringUtils.replacePattern(s, "\\s{1,}", "-");
			s = StringUtils.replacePattern(s, "[^\\w-]", "");
			s = StringUtils.replacePattern(s, "-{2,}", "-");
			c.o(s);
		}
		else if(pk != null){
			c.o(pk.toString());
		}
	}

	/**	la version plus courte de l'URL qui commence avec « / » 
	 * {@inheritDoc}
	 * Indexe: true
	 * Stocke: true
	 * VarUrl: true
	 * r: codeTransactionId
	 * r.enUS: transactionCodeId
	 * r: /code-transaction/
	 * r.enUS: /transaction-code/
	 * r: requeteSite
	 * r.enUS: siteRequest
	 * r: ConfigSite
	 * r.enUS: SiteConfig
	 * r: SiteUrlBase
	 * r.enUS: SiteBaseUrl
	 * **/   
	protected void _pageUrl(Couverture<String> c)  {
		if(codeTransactionId != null) {
			String o = requeteSite_.getConfigSite_().getSiteUrlBase() + "/code-transaction/" + codeTransactionId;
			c.o(o);
		}
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: objectSuggest
	 * Suggere: true
	 * r: codeTransactionNomComplet
	 * r.enUS: transactionCodeCompleteName
	 */         
	protected void _objetSuggere(Couverture<String> c) { 
		c.o(codeTransactionNomComplet);
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: _classCanonicalNames
	 * Indexe: true
	 * Stocke: true
	 * r: CodeTransaction
	 * r.enUS: TransactionCode
	 * r: classeNomsCanoniques
	 * r.enUS: classCanonicalNames
	 **/      
	@Override protected void _classeNomsCanoniques(List<String> l) {
		l.add(CodeTransaction.class.getCanonicalName());
		super._classeNomsCanoniques(l);
	}
}

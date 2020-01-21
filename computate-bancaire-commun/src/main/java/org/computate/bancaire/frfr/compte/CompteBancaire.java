package org.computate.bancaire.frfr.compte;  

import java.text.Normalizer;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.frfr.cluster.Cluster;
import org.computate.bancaire.frfr.couverture.Couverture;

/**                                   
 * NomCanonique.enUS: org.computate.bancaire.enus.account.BankAccount
 * Modele: true
 * Api: true
 * Indexe: true
 * Sauvegarde: true
 * 
 * ApiTag.frFR: Compte
 * ApiUri.frFR: /api/compte
 * 
 * ApiTag.enUS: Account
 * ApiUri.enUS: /api/account
 * 
 * ApiMethode: POST
 * ApiMethode: PATCH
 * ApiMethode: GET
 * ApiMethode: DELETE
 * ApiMethode.frFR: Recherche
 * ApiMethode.enUS: Search
 * 
 * ApiMethode.frFR: PageRecherche
 * PagePageRecherche.frFR: ComptePage
 * PageSuperPageRecherche.frFR: ClusterPage
 * ApiUriPageRecherche.frFR: /compte
 * 
 * ApiMethode.enUS: SearchPage
 * PageSearchPage.enUS: AccountPage
 * PageSuperSearchPage.enUS: ClusterPage
 * ApiUriSearchPage.enUS: /account
 * 
 * UnNom.frFR: un compte
 * UnNom.enUS: an account
 * Adectif.frFR: bancaire
 * Adjectif.enUS: bank
 * Couleur: gray
 * IconeGroupe: duotone
 * IconeNom: money-check
 * 
 * Role.frFR: SiteAdmin
 * Role.enUS: SiteAdmin
 */                   
public class CompteBancaire extends CompteBancaireGen<Cluster> {

	/**
	 * {@inheritDoc}
	 * Var.enUS: accountKey
	 * Indexe: true
	 * Stocke: true
	 * Description.frFR: La clé primaire de l'école dans la base de données. 
	 * Description.enUS: The primary key of the account in the database. 
	 * NomAffichage.frFR: clé
	 * NomAffichage.enUS: key
	 */         
	protected void _compteCle(Couverture<Long> c) {
		c.o(pk);
	}
	
	/**
	 * {@inheritDoc}
	 * Var.enUS: yearKeys
	 * Indexe: true
	 * Stocke: true
	 * Attribuer: TransactionCompte.compteCle
	 * HtmlLigne: 3
	 * HtmlCellule: 1
	 * Description.frFR: 
	 * Description.enUS: 
	 * NomAffichage.frFR: transactions
	 * NomAffichage.enUS: transactions
	 */  
	protected void _transactionCles(List<Long> o) {}

	/**
	 * {@inheritDoc}
	 * Var.enUS: accountNumber
	 * Definir: true
	 * Indexe: true
	 * Stocke: true
	 * HtmlLigne: 3
	 * HtmlCellule: 1
	 * NomAffichage.frFR: numéro de compte
	 * NomAffichage.enUS: account number
	 */   
	protected void _compteNumero(Couverture<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: accountPhoneNumber
	 * Definir: true
	 * Indexe: true
	 * Stocke: true
	 * HtmlLigne: 4
	 * HtmlCellule: 1
	 * NomAffichage.frFR: numéro de téléphone
	 * NomAffichage.enUS: phone number
	 * Description.frFR: Numéro de téléphone de l'école. 
	 * Description.enUS: Telephone number of the account. 
	 */         
	protected void _compteNumeroTelephone(Couverture<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: accountAdministratorName
	 * Definir: true
	 * Indexe: true
	 * Stocke: true
	 * HtmlLigne: 3
	 * HtmlCellule: 2
	 * NomAffichage.enUS: administrator of the account
	 * NomAffichage.frFR: administrateur de l'école
	 * Description.frFR: 
	 * Description.enUS: 
	 */               
	protected void _compteAdministrateurNom(Couverture<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: accountLocation
	 * Definir: true
	 * Indexe: true
	 * Stocke: true
	 * HtmlLigne: 3
	 * HtmlCellule: 3
	 * NomAffichage.enUS: location
	 * NomAffichage.frFR: l'emplacement
	 * Description.frFR: 
	 * Description.enUS: 
	 */               
	protected void _compteEmplacement(Couverture<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: accountAddress
	 * Definir: true
	 * Indexe: true
	 * Stocke: true
	 * HtmlLigne: 4
	 * HtmlCellule: 2
	 * Multiligne: true
	 * NomAffichage.frFR: addresse
	 * NomAffichage.enUS: address
	 * Description.frFR: 
	 * Description.enUS: 
	 */
	protected void _compteAddresse(Couverture<String> c) {
	}
	
	/**
	 * {@inheritDoc}
	 * Var.enUS: objectSuggestWeight
	 * Description.frFR: 
	 * Description.enUS: 
	 * NomAffichage.frFR: 
	 * NomAffichage.enUS: 
	 */    
	protected void _objetSuggerePoids(Couverture<Double> c) {
		c.o(1D);
	}
	
	/**  
	 * {@inheritDoc}
	 * Var.enUS: objectSuggest
	 * Suggere: true
	 * Description.frFR: 
	 * Description.enUS: 
	 * NomAffichage.frFR: 
	 * NomAffichage.enUS: 
	 * r: compteNumero
	 * r.enUS: accountNumber
	 */
	protected void _objetSuggere(Couverture<String> c) { 
		c.o(compteNumero);
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: accountShortName
	 * Indexe: true
	 * Stocke: true
	 * Description.frFR: 
	 * Description.enUS: 
	 * NomAffichage.frFR: 
	 * NomAffichage.enUS: 
	 * r: compteNumero
	 * r.enUS: accountNumber
	 * r: compteEmplacement
	 * r.enUS: accountLocation
	 */   
	protected void _compteNumeroCourt(Couverture<String> c) {
		if(compteEmplacement != null)
			c.o(compteEmplacement);
		else 
			c.o(compteNumero);
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: accountCompleteName
	 * Indexe: true
	 * Stocke: true
	 * NomAffichage.frFR: nom
	 * NomAffichage.enUS: name
	 * HtmlColonne: 1
	 * r: compteNumero
	 * r.enUS: accountNumber
	 * VarTitre: true
	 * r: compteEmplacement
	 * r.enUS: accountLocation
	 * r: "%s à %s"
	 * r.enUS: "%s at %s"
	 */        
	protected void _compteNomComplet(Couverture<String> c) {
		if(compteEmplacement != null)
			c.o(String.format("%s à %s", compteNumero, compteEmplacement));
		else 
			c.o(compteNumero);
	}

	/**   
	 * {@inheritDoc}
	 * Var.enUS: accountId
	 * Indexe: true
	 * Stocke: true
	 * VarId: true
	 * HtmlLigne: 1
	 * HtmlCellule: 4
	 * Description.frFR: 
	 * Description.enUS: 
	 * NomAffichage.frFR: ID
	 * NomAffichage.enUS: ID
	 * r: compteNumero
	 * r.enUS: accountNumber
	 */                   
	protected void _compteId(Couverture<String> c) {
		if(compteNumero != null) {
			String s = Normalizer.normalize(compteNumero, Normalizer.Form.NFD);
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
	 * r: compteId
	 * r.enUS: accountId
	 * r: /frFR/compte/
	 * r.enUS: /account/
	 * r: requeteSite
	 * r.enUS: siteRequest
	 * r: ConfigSite
	 * r.enUS: SiteConfig
	 * r: SiteUrlBase
	 * r.enUS: SiteBaseUrl
	 * **/    
	protected void _pageUrl(Couverture<String> c)  {
		if(compteId != null) {
			String o = requeteSite_.getConfigSite_().getSiteUrlBase() + "/frFR/compte/" + compteId;
			c.o(o);
		}
	}

	/**
	 * r: compteNumero
	 * r.enUS: accountNumber
	 * r: Compte : 
	 * r.enUS: Account: 
	 */ 
	protected void _pageH1(Couverture<String> c)  {
		c.o("Compte : " + compteNumero);
	}

	public void htmlBody() {
		super.htmlBody();
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: _classCanonicalNames
	 * Indexe: true
	 * Stocke: true
	 * r: CompteBancaire
	 * r.enUS: BankAccount
	 * r: classeNomsCanoniques
	 * r.enUS: classCanonicalNames
	 **/      
	@Override protected void _classeNomsCanoniques(List<String> l) {
		l.add(CompteBancaire.class.getCanonicalName());
		super._classeNomsCanoniques(l);
	}
}

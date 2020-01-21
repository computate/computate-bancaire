
// POST //

async function postBankAccount($formValues, success, error) {
	var vals = {};
	if(success == null) {
		success = function( data, textStatus, jQxhr ) {
			addGlow($formValues.next('button'));
		};
	}
	if(error == null) {
		error = function( jqXhr, textStatus, errorThrown ) {
			addError($formValues.next('button'));
		};
	}

	var valuePk = $formValues.find('.valuePk').val();
	if(valuePk != null && valuePk !== '')
		vals['pk'] = valuePk;

	var valueCreated = $formValues.find('.valueCreated').val();
	if(valueCreated != null && valueCreated !== '')
		vals['created'] = valueCreated;

	var valueModified = $formValues.find('.valueModified').val();
	if(valueModified != null && valueModified !== '')
		vals['modified'] = valueModified;

	var valueObjectId = $formValues.find('.valueObjectId').val();
	if(valueObjectId != null && valueObjectId !== '')
		vals['objectId'] = valueObjectId;

	var valueAccountId = $formValues.find('.valueAccountId').val();
	if(valueAccountId != null && valueAccountId !== '')
		vals['accountId'] = valueAccountId;

	var valueArchived = $formValues.find('.valueArchived').prop('checked');
	if(valueArchived != null && valueArchived !== '')
		vals['archived'] = valueArchived;

	var valueDeleted = $formValues.find('.valueDeleted').prop('checked');
	if(valueDeleted != null && valueDeleted !== '')
		vals['deleted'] = valueDeleted;

	var valueYearKeys = $formValues.find('.valueYearKeys').val();
	if(valueYearKeys != null && valueYearKeys !== '')
		vals['yearKeys'] = valueYearKeys;

	var valueAccountNumber = $formValues.find('.valueAccountNumber').val();
	if(valueAccountNumber != null && valueAccountNumber !== '')
		vals['accountNumber'] = valueAccountNumber;

	var valueAccountAdministratorName = $formValues.find('.valueAccountAdministratorName').val();
	if(valueAccountAdministratorName != null && valueAccountAdministratorName !== '')
		vals['accountAdministratorName'] = valueAccountAdministratorName;

	var valueAccountLocation = $formValues.find('.valueAccountLocation').val();
	if(valueAccountLocation != null && valueAccountLocation !== '')
		vals['accountLocation'] = valueAccountLocation;

	var valueAccountPhoneNumber = $formValues.find('.valueAccountPhoneNumber').val();
	if(valueAccountPhoneNumber != null && valueAccountPhoneNumber !== '')
		vals['accountPhoneNumber'] = valueAccountPhoneNumber;

	var valueAccountAddress = $formValues.find('.valueAccountAddress').val();
	if(valueAccountAddress != null && valueAccountAddress !== '')
		vals['accountAddress'] = valueAccountAddress;

	var valueAccountCompleteName = $formValues.find('.valueAccountCompleteName').val();
	if(valueAccountCompleteName != null && valueAccountCompleteName !== '')
		vals['accountCompleteName'] = valueAccountCompleteName;

	$.ajax({
		url: '/api/account'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

function postBankAccountVals(vals, success, error) {
	$.ajax({
		url: '/api/account'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// PATCH //

async function patchBankAccount($formFilters, $formValues, success, error) {
	var filters = patchBankAccountFilters($formFilters);

	var vals = {};

	var removePk = $formFilters.find('.removePk').val() === 'true';
	var setPk = removePk ? null : $formValues.find('.setPk').val();
	if(removePk || setPk != null && setPk !== '')
		vals['setPk'] = setPk;
	var addPk = $formValues.find('.addPk').val();
	if(addPk != null && addPk !== '')
		vals['addPk'] = addPk;
	var removePk = $formValues.find('.removePk').val();
	if(removePk != null && removePk !== '')
		vals['removePk'] = removePk;

	var removeCreated = $formFilters.find('.removeCreated').val() === 'true';
	var setCreated = removeCreated ? null : $formValues.find('.setCreated').val();
	if(removeCreated || setCreated != null && setCreated !== '')
		vals['setCreated'] = setCreated;
	var addCreated = $formValues.find('.addCreated').val();
	if(addCreated != null && addCreated !== '')
		vals['addCreated'] = addCreated;
	var removeCreated = $formValues.find('.removeCreated').val();
	if(removeCreated != null && removeCreated !== '')
		vals['removeCreated'] = removeCreated;

	var removeModified = $formFilters.find('.removeModified').val() === 'true';
	var setModified = removeModified ? null : $formValues.find('.setModified').val();
	if(removeModified || setModified != null && setModified !== '')
		vals['setModified'] = setModified;
	var addModified = $formValues.find('.addModified').val();
	if(addModified != null && addModified !== '')
		vals['addModified'] = addModified;
	var removeModified = $formValues.find('.removeModified').val();
	if(removeModified != null && removeModified !== '')
		vals['removeModified'] = removeModified;

	var removeObjectId = $formFilters.find('.removeObjectId').val() === 'true';
	var setObjectId = removeObjectId ? null : $formValues.find('.setObjectId').val();
	if(removeObjectId || setObjectId != null && setObjectId !== '')
		vals['setObjectId'] = setObjectId;
	var addObjectId = $formValues.find('.addObjectId').val();
	if(addObjectId != null && addObjectId !== '')
		vals['addObjectId'] = addObjectId;
	var removeObjectId = $formValues.find('.removeObjectId').val();
	if(removeObjectId != null && removeObjectId !== '')
		vals['removeObjectId'] = removeObjectId;

	var removeAccountId = $formFilters.find('.removeAccountId').val() === 'true';
	var setAccountId = removeAccountId ? null : $formValues.find('.setAccountId').val();
	if(removeAccountId || setAccountId != null && setAccountId !== '')
		vals['setAccountId'] = setAccountId;
	var addAccountId = $formValues.find('.addAccountId').val();
	if(addAccountId != null && addAccountId !== '')
		vals['addAccountId'] = addAccountId;
	var removeAccountId = $formValues.find('.removeAccountId').val();
	if(removeAccountId != null && removeAccountId !== '')
		vals['removeAccountId'] = removeAccountId;

	var removeArchived = $formFilters.find('.removeArchived').val() === 'true';
	var setArchived = removeArchived ? null : $formValues.find('.setArchived').prop('checked');
	if(removeArchived || setArchived != null && setArchived !== '')
		vals['setArchived'] = setArchived;
	var addArchived = $formValues.find('.addArchived').prop('checked');
	if(addArchived != null && addArchived !== '')
		vals['addArchived'] = addArchived;
	var removeArchived = $formValues.find('.removeArchived').prop('checked');
	if(removeArchived != null && removeArchived !== '')
		vals['removeArchived'] = removeArchived;

	var removeDeleted = $formFilters.find('.removeDeleted').val() === 'true';
	var setDeleted = removeDeleted ? null : $formValues.find('.setDeleted').prop('checked');
	if(removeDeleted || setDeleted != null && setDeleted !== '')
		vals['setDeleted'] = setDeleted;
	var addDeleted = $formValues.find('.addDeleted').prop('checked');
	if(addDeleted != null && addDeleted !== '')
		vals['addDeleted'] = addDeleted;
	var removeDeleted = $formValues.find('.removeDeleted').prop('checked');
	if(removeDeleted != null && removeDeleted !== '')
		vals['removeDeleted'] = removeDeleted;

	var removeYearKeys = $formFilters.find('.removeYearKeys').val() === 'true';
	var setYearKeys = removeYearKeys ? null : $formValues.find('.setYearKeys').val();
	if(removeYearKeys || setYearKeys != null && setYearKeys !== '')
		vals['setYearKeys'] = setYearKeys;
	var addYearKeys = $formValues.find('.addYearKeys').val();
	if(addYearKeys != null && addYearKeys !== '')
		vals['addYearKeys'] = addYearKeys;
	var removeYearKeys = $formValues.find('.removeYearKeys').val();
	if(removeYearKeys != null && removeYearKeys !== '')
		vals['removeYearKeys'] = removeYearKeys;

	var removeAccountNumber = $formFilters.find('.removeAccountNumber').val() === 'true';
	var setAccountNumber = removeAccountNumber ? null : $formValues.find('.setAccountNumber').val();
	if(removeAccountNumber || setAccountNumber != null && setAccountNumber !== '')
		vals['setAccountNumber'] = setAccountNumber;
	var addAccountNumber = $formValues.find('.addAccountNumber').val();
	if(addAccountNumber != null && addAccountNumber !== '')
		vals['addAccountNumber'] = addAccountNumber;
	var removeAccountNumber = $formValues.find('.removeAccountNumber').val();
	if(removeAccountNumber != null && removeAccountNumber !== '')
		vals['removeAccountNumber'] = removeAccountNumber;

	var removeAccountAdministratorName = $formFilters.find('.removeAccountAdministratorName').val() === 'true';
	var setAccountAdministratorName = removeAccountAdministratorName ? null : $formValues.find('.setAccountAdministratorName').val();
	if(removeAccountAdministratorName || setAccountAdministratorName != null && setAccountAdministratorName !== '')
		vals['setAccountAdministratorName'] = setAccountAdministratorName;
	var addAccountAdministratorName = $formValues.find('.addAccountAdministratorName').val();
	if(addAccountAdministratorName != null && addAccountAdministratorName !== '')
		vals['addAccountAdministratorName'] = addAccountAdministratorName;
	var removeAccountAdministratorName = $formValues.find('.removeAccountAdministratorName').val();
	if(removeAccountAdministratorName != null && removeAccountAdministratorName !== '')
		vals['removeAccountAdministratorName'] = removeAccountAdministratorName;

	var removeAccountLocation = $formFilters.find('.removeAccountLocation').val() === 'true';
	var setAccountLocation = removeAccountLocation ? null : $formValues.find('.setAccountLocation').val();
	if(removeAccountLocation || setAccountLocation != null && setAccountLocation !== '')
		vals['setAccountLocation'] = setAccountLocation;
	var addAccountLocation = $formValues.find('.addAccountLocation').val();
	if(addAccountLocation != null && addAccountLocation !== '')
		vals['addAccountLocation'] = addAccountLocation;
	var removeAccountLocation = $formValues.find('.removeAccountLocation').val();
	if(removeAccountLocation != null && removeAccountLocation !== '')
		vals['removeAccountLocation'] = removeAccountLocation;

	var removeAccountPhoneNumber = $formFilters.find('.removeAccountPhoneNumber').val() === 'true';
	var setAccountPhoneNumber = removeAccountPhoneNumber ? null : $formValues.find('.setAccountPhoneNumber').val();
	if(removeAccountPhoneNumber || setAccountPhoneNumber != null && setAccountPhoneNumber !== '')
		vals['setAccountPhoneNumber'] = setAccountPhoneNumber;
	var addAccountPhoneNumber = $formValues.find('.addAccountPhoneNumber').val();
	if(addAccountPhoneNumber != null && addAccountPhoneNumber !== '')
		vals['addAccountPhoneNumber'] = addAccountPhoneNumber;
	var removeAccountPhoneNumber = $formValues.find('.removeAccountPhoneNumber').val();
	if(removeAccountPhoneNumber != null && removeAccountPhoneNumber !== '')
		vals['removeAccountPhoneNumber'] = removeAccountPhoneNumber;

	var removeAccountAddress = $formFilters.find('.removeAccountAddress').val() === 'true';
	var setAccountAddress = removeAccountAddress ? null : $formValues.find('.setAccountAddress').val();
	if(removeAccountAddress || setAccountAddress != null && setAccountAddress !== '')
		vals['setAccountAddress'] = setAccountAddress;
	var addAccountAddress = $formValues.find('.addAccountAddress').val();
	if(addAccountAddress != null && addAccountAddress !== '')
		vals['addAccountAddress'] = addAccountAddress;
	var removeAccountAddress = $formValues.find('.removeAccountAddress').val();
	if(removeAccountAddress != null && removeAccountAddress !== '')
		vals['removeAccountAddress'] = removeAccountAddress;

	var removeAccountCompleteName = $formFilters.find('.removeAccountCompleteName').val() === 'true';
	var setAccountCompleteName = removeAccountCompleteName ? null : $formValues.find('.setAccountCompleteName').val();
	if(removeAccountCompleteName || setAccountCompleteName != null && setAccountCompleteName !== '')
		vals['setAccountCompleteName'] = setAccountCompleteName;
	var addAccountCompleteName = $formValues.find('.addAccountCompleteName').val();
	if(addAccountCompleteName != null && addAccountCompleteName !== '')
		vals['addAccountCompleteName'] = addAccountCompleteName;
	var removeAccountCompleteName = $formValues.find('.removeAccountCompleteName').val();
	if(removeAccountCompleteName != null && removeAccountCompleteName !== '')
		vals['removeAccountCompleteName'] = removeAccountCompleteName;

	patchBankAccountVals(filters, vals, success, error);
}

function patchBankAccountFilters($formFilters) {
	var filters = [];

	var filterPk = $formFilters.find('.valuePk').val();
	if(filterPk != null && filterPk !== '')
		filters.push({ name: 'fq', value: 'pk:' + filterPk });

	var filterCreated = $formFilters.find('.valueCreated').val();
	if(filterCreated != null && filterCreated !== '')
		filters.push({ name: 'fq', value: 'created:' + filterCreated });

	var filterModified = $formFilters.find('.valueModified').val();
	if(filterModified != null && filterModified !== '')
		filters.push({ name: 'fq', value: 'modified:' + filterModified });

	var filterObjectId = $formFilters.find('.valueObjectId').val();
	if(filterObjectId != null && filterObjectId !== '')
		filters.push({ name: 'fq', value: 'objectId:' + filterObjectId });

	var filterAccountId = $formFilters.find('.valueAccountId').val();
	if(filterAccountId != null && filterAccountId !== '')
		filters.push({ name: 'fq', value: 'accountId:' + filterAccountId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterYearKeys = $formFilters.find('.valueYearKeys').val();
	if(filterYearKeys != null && filterYearKeys !== '')
		filters.push({ name: 'fq', value: 'yearKeys:' + filterYearKeys });

	var filterAccountNumber = $formFilters.find('.valueAccountNumber').val();
	if(filterAccountNumber != null && filterAccountNumber !== '')
		filters.push({ name: 'fq', value: 'accountNumber:' + filterAccountNumber });

	var filterAccountAdministratorName = $formFilters.find('.valueAccountAdministratorName').val();
	if(filterAccountAdministratorName != null && filterAccountAdministratorName !== '')
		filters.push({ name: 'fq', value: 'accountAdministratorName:' + filterAccountAdministratorName });

	var filterAccountLocation = $formFilters.find('.valueAccountLocation').val();
	if(filterAccountLocation != null && filterAccountLocation !== '')
		filters.push({ name: 'fq', value: 'accountLocation:' + filterAccountLocation });

	var filterAccountPhoneNumber = $formFilters.find('.valueAccountPhoneNumber').val();
	if(filterAccountPhoneNumber != null && filterAccountPhoneNumber !== '')
		filters.push({ name: 'fq', value: 'accountPhoneNumber:' + filterAccountPhoneNumber });

	var filterAccountAddress = $formFilters.find('.valueAccountAddress').val();
	if(filterAccountAddress != null && filterAccountAddress !== '')
		filters.push({ name: 'fq', value: 'accountAddress:' + filterAccountAddress });

	var filterId = $formFilters.find('.valueId').val();
	if(filterId != null && filterId !== '')
		filters.push({ name: 'fq', value: 'id:' + filterId });

	var filterClassCanonicalName = $formFilters.find('.valueClassCanonicalName').val();
	if(filterClassCanonicalName != null && filterClassCanonicalName !== '')
		filters.push({ name: 'fq', value: 'classCanonicalName:' + filterClassCanonicalName });

	var filterClassSimpleName = $formFilters.find('.valueClassSimpleName').val();
	if(filterClassSimpleName != null && filterClassSimpleName !== '')
		filters.push({ name: 'fq', value: 'classSimpleName:' + filterClassSimpleName });

	var filterClassCanonicalNames = $formFilters.find('.valueClassCanonicalNames').val();
	if(filterClassCanonicalNames != null && filterClassCanonicalNames !== '')
		filters.push({ name: 'fq', value: 'classCanonicalNames:' + filterClassCanonicalNames });

	var filterObjectTitle = $formFilters.find('.valueObjectTitle').val();
	if(filterObjectTitle != null && filterObjectTitle !== '')
		filters.push({ name: 'fq', value: 'objectTitle:' + filterObjectTitle });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });

	var filterAccountKey = $formFilters.find('.valueAccountKey').val();
	if(filterAccountKey != null && filterAccountKey !== '')
		filters.push({ name: 'fq', value: 'accountKey:' + filterAccountKey });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });

	var filterAccountShortName = $formFilters.find('.valueAccountShortName').val();
	if(filterAccountShortName != null && filterAccountShortName !== '')
		filters.push({ name: 'fq', value: 'accountShortName:' + filterAccountShortName });

	var filterAccountCompleteName = $formFilters.find('.valueAccountCompleteName').val();
	if(filterAccountCompleteName != null && filterAccountCompleteName !== '')
		filters.push({ name: 'fq', value: 'accountCompleteName:' + filterAccountCompleteName });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });
	return filters;
}

function patchBankAccountVal(filters, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchBankAccountVals(filters, vals, success, error);
}

function patchBankAccountVals(filters, vals, success, error) {
	$.ajax({
		url: '/api/account?' + $.param(filters)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// GET //

async function getBankAccount(pk) {
	$.ajax({
		url: '/api/account/' + id
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

// DELETE //

async function deleteBankAccount(pk) {
	$.ajax({
		url: '/api/account/' + id
		, dataType: 'json'
		, type: 'DELETE'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// Search //

async function searchBankAccount($formFilters, success, error) {
	var filters = searchBankAccountFilters($formFilters);
	if(success == null)
		success = function( data, textStatus, jQxhr ) {};
	if(error == null)
		error = function( jqXhr, textStatus, errorThrown ) {};

	searchBankAccountVals(filters, success, error);
}

function searchBankAccountFilters($formFilters) {
	var filters = [];

	var filterPk = $formFilters.find('.valuePk').val();
	if(filterPk != null && filterPk !== '')
		filters.push({ name: 'fq', value: 'pk:' + filterPk });

	var filterCreated = $formFilters.find('.valueCreated').val();
	if(filterCreated != null && filterCreated !== '')
		filters.push({ name: 'fq', value: 'created:' + filterCreated });

	var filterModified = $formFilters.find('.valueModified').val();
	if(filterModified != null && filterModified !== '')
		filters.push({ name: 'fq', value: 'modified:' + filterModified });

	var filterObjectId = $formFilters.find('.valueObjectId').val();
	if(filterObjectId != null && filterObjectId !== '')
		filters.push({ name: 'fq', value: 'objectId:' + filterObjectId });

	var filterAccountId = $formFilters.find('.valueAccountId').val();
	if(filterAccountId != null && filterAccountId !== '')
		filters.push({ name: 'fq', value: 'accountId:' + filterAccountId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterYearKeys = $formFilters.find('.valueYearKeys').val();
	if(filterYearKeys != null && filterYearKeys !== '')
		filters.push({ name: 'fq', value: 'yearKeys:' + filterYearKeys });

	var filterAccountNumber = $formFilters.find('.valueAccountNumber').val();
	if(filterAccountNumber != null && filterAccountNumber !== '')
		filters.push({ name: 'fq', value: 'accountNumber:' + filterAccountNumber });

	var filterAccountAdministratorName = $formFilters.find('.valueAccountAdministratorName').val();
	if(filterAccountAdministratorName != null && filterAccountAdministratorName !== '')
		filters.push({ name: 'fq', value: 'accountAdministratorName:' + filterAccountAdministratorName });

	var filterAccountLocation = $formFilters.find('.valueAccountLocation').val();
	if(filterAccountLocation != null && filterAccountLocation !== '')
		filters.push({ name: 'fq', value: 'accountLocation:' + filterAccountLocation });

	var filterAccountPhoneNumber = $formFilters.find('.valueAccountPhoneNumber').val();
	if(filterAccountPhoneNumber != null && filterAccountPhoneNumber !== '')
		filters.push({ name: 'fq', value: 'accountPhoneNumber:' + filterAccountPhoneNumber });

	var filterAccountAddress = $formFilters.find('.valueAccountAddress').val();
	if(filterAccountAddress != null && filterAccountAddress !== '')
		filters.push({ name: 'fq', value: 'accountAddress:' + filterAccountAddress });

	var filterId = $formFilters.find('.valueId').val();
	if(filterId != null && filterId !== '')
		filters.push({ name: 'fq', value: 'id:' + filterId });

	var filterClassCanonicalName = $formFilters.find('.valueClassCanonicalName').val();
	if(filterClassCanonicalName != null && filterClassCanonicalName !== '')
		filters.push({ name: 'fq', value: 'classCanonicalName:' + filterClassCanonicalName });

	var filterClassSimpleName = $formFilters.find('.valueClassSimpleName').val();
	if(filterClassSimpleName != null && filterClassSimpleName !== '')
		filters.push({ name: 'fq', value: 'classSimpleName:' + filterClassSimpleName });

	var filterClassCanonicalNames = $formFilters.find('.valueClassCanonicalNames').val();
	if(filterClassCanonicalNames != null && filterClassCanonicalNames !== '')
		filters.push({ name: 'fq', value: 'classCanonicalNames:' + filterClassCanonicalNames });

	var filterObjectTitle = $formFilters.find('.valueObjectTitle').val();
	if(filterObjectTitle != null && filterObjectTitle !== '')
		filters.push({ name: 'fq', value: 'objectTitle:' + filterObjectTitle });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });

	var filterAccountKey = $formFilters.find('.valueAccountKey').val();
	if(filterAccountKey != null && filterAccountKey !== '')
		filters.push({ name: 'fq', value: 'accountKey:' + filterAccountKey });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });

	var filterAccountShortName = $formFilters.find('.valueAccountShortName').val();
	if(filterAccountShortName != null && filterAccountShortName !== '')
		filters.push({ name: 'fq', value: 'accountShortName:' + filterAccountShortName });

	var filterAccountCompleteName = $formFilters.find('.valueAccountCompleteName').val();
	if(filterAccountCompleteName != null && filterAccountCompleteName !== '')
		filters.push({ name: 'fq', value: 'accountCompleteName:' + filterAccountCompleteName });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });
	return filters;
}

function searchBankAccountVals(filters, success, error) {
	$.ajax({
		url: '/api/account?' + $.param(filters)
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

function suggestBankAccountObjectSuggest($formFilters, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-money-check w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['accountCompleteName']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchBankAccountVals($formFilters, success, error);
}

function suggestBankAccountObjectSuggest($formFilters, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-money-check w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['accountCompleteName']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchBankAccountVals($formFilters, success, error);
}

async function websocketBankAccount(success) {
	window.eventBus.onopen = function () {

		window.eventBus.registerHandler('websocketBankAccount', function (error, message) {
			var json = JSON.parse(message['body']);
			var id = json['id'];
			var pk = json['pk'];
			var pks = json['pks'];
			var empty = json['empty'];
			if(!empty) {
				var numFound = json['numFound'];
				var numPATCH = json['numPATCH'];
				var percent = Math.floor( numPATCH / numFound * 100 ) + '%';
				var $box = $('<div>').attr('class', 'w3-display-topright w3-quarter box-' + id + ' ').attr('id', 'box-' + id);
				var $margin = $('<div>').attr('class', 'w3-margin ').attr('id', 'margin-' + id);
				var $card = $('<div>').attr('class', 'w3-card ').attr('id', 'card-' + id);
				var $header = $('<div>').attr('class', 'w3-container fa-gray ').attr('id', 'header-' + id);
				var $i = $('<i>').attr('class', 'fad fa-money-check w3-margin-right ').attr('id', 'icon-' + id);
				var $headerSpan = $('<span>').attr('class', '').text('modify bank accounts');
				var $x = $('<span>').attr('class', 'w3-button w3-display-topright ').attr('onclick', '$("#card-' + id + '").hide(); ').attr('id', 'x-' + id);
				var $body = $('<div>').attr('class', 'w3-container w3-padding ').attr('id', 'text-' + id);
				var $bar = $('<div>').attr('class', 'w3-light-gray ').attr('id', 'bar-' + id);
				var $progress = $('<div>').attr('class', 'w3-gray ').attr('style', 'height: 24px; width: ' + percent + '; ').attr('id', 'progress-' + id).text(numPATCH + '/' + numFound);
				$card.append($header);
				$header.append($i);
				$header.append($headerSpan);
				$header.append($x);
				$body.append($bar);
				$bar.append($progress);
				$card.append($body);
				$box.append($margin);
				$margin.append($card);
				$('.box-' + id).remove();
				if(numPATCH < numFound)
				$('.w3-content').append($box);
				if(success)
					success(json);
			}
		});
	}
}
async function websocketBankAccountInner(patchRequest) {
	var pk = patchRequest['pk'];
	var pks = patchRequest['pks'];
	var classes = patchRequest['classes'];
	var vars = patchRequest['vars'];
	var empty = patchRequest['empty'];

	if(pk != null) {
		searchBankAccountVals([ {name: 'fq', value: 'pk:' + pk} ], function( data, textStatus, jQxhr ) {
			var o = data['list'][0];
			if(vars.includes('created')) {
				$('.inputBankAccount' + pk + 'Created').val(o['created']);
				$('.varBankAccount' + pk + 'Created').text(o['created']);
			}
			if(vars.includes('modified')) {
				$('.inputBankAccount' + pk + 'Modified').val(o['modified']);
				$('.varBankAccount' + pk + 'Modified').text(o['modified']);
			}
			if(vars.includes('archived')) {
				$('.inputBankAccount' + pk + 'Archived').val(o['archived']);
				$('.varBankAccount' + pk + 'Archived').text(o['archived']);
			}
			if(vars.includes('deleted')) {
				$('.inputBankAccount' + pk + 'Deleted').val(o['deleted']);
				$('.varBankAccount' + pk + 'Deleted').text(o['deleted']);
			}
			if(vars.includes('accountNumber')) {
				$('.inputBankAccount' + pk + 'AccountNumber').val(o['accountNumber']);
				$('.varBankAccount' + pk + 'AccountNumber').text(o['accountNumber']);
			}
			if(vars.includes('accountAdministratorName')) {
				$('.inputBankAccount' + pk + 'AccountAdministratorName').val(o['accountAdministratorName']);
				$('.varBankAccount' + pk + 'AccountAdministratorName').text(o['accountAdministratorName']);
			}
			if(vars.includes('accountLocation')) {
				$('.inputBankAccount' + pk + 'AccountLocation').val(o['accountLocation']);
				$('.varBankAccount' + pk + 'AccountLocation').text(o['accountLocation']);
			}
			if(vars.includes('accountPhoneNumber')) {
				$('.inputBankAccount' + pk + 'AccountPhoneNumber').val(o['accountPhoneNumber']);
				$('.varBankAccount' + pk + 'AccountPhoneNumber').text(o['accountPhoneNumber']);
			}
			if(vars.includes('accountAddress')) {
				$('.inputBankAccount' + pk + 'AccountAddress').val(o['accountAddress']);
				$('.varBankAccount' + pk + 'AccountAddress').text(o['accountAddress']);
			}
		});
	}

	if(!empty) {
		if(pks) {
			for(i=0; i < pks.length; i++) {
				var pk2 = pks[i];
				var c = classes[i];
				await window['patch' + c + 'Vals']( [ {name: 'fq', value: 'pk:' + pk2} ], {});
			}
		}
		await patchBankAccountVals( [ {name: 'fq', value: 'pk:' + pk} ], {});
	}
}

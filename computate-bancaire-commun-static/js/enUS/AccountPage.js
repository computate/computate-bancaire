
// POST //

function postBankAccount($formValues) {
	var vals = {};

	var valuePk = $formValues.find('.valuePk').val();
	if(valuePk != null && valuePk !== '')
		vals['pk'] = valuePk;

	var valueCreated = $formValues.find('.valueCreated').val();
	if(valueCreated != null && valueCreated !== '')
		vals['created'] = valueCreated;

	var valueModified = $formValues.find('.valueModified').val();
	if(valueModified != null && valueModified !== '')
		vals['modified'] = valueModified;

	var valueAccountId = $formValues.find('.valueAccountId').val();
	if(valueAccountId != null && valueAccountId !== '')
		vals['accountId'] = valueAccountId;

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

function patchBankAccount($formFilters, $formValues, success, error) {
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

	var filterAccountId = $formFilters.find('.valueAccountId').val();
	if(filterAccountId != null && filterAccountId !== '')
		filters.push({ name: 'fq', value: 'accountId:' + filterAccountId });

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

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterClassCanonicalName = $formFilters.find('.valueClassCanonicalName').val();
	if(filterClassCanonicalName != null && filterClassCanonicalName !== '')
		filters.push({ name: 'fq', value: 'classCanonicalName:' + filterClassCanonicalName });

	var filterClassSimpleName = $formFilters.find('.valueClassSimpleName').val();
	if(filterClassSimpleName != null && filterClassSimpleName !== '')
		filters.push({ name: 'fq', value: 'classSimpleName:' + filterClassSimpleName });

	var filterClassCanonicalNames = $formFilters.find('.valueClassCanonicalNames').val();
	if(filterClassCanonicalNames != null && filterClassCanonicalNames !== '')
		filters.push({ name: 'fq', value: 'classCanonicalNames:' + filterClassCanonicalNames });

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

function getBankAccount(pk) {
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

function deleteBankAccount(pk) {
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

function searchBankAccount($formFilters, success, error) {
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

	var filterAccountId = $formFilters.find('.valueAccountId').val();
	if(filterAccountId != null && filterAccountId !== '')
		filters.push({ name: 'fq', value: 'accountId:' + filterAccountId });

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

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterClassCanonicalName = $formFilters.find('.valueClassCanonicalName').val();
	if(filterClassCanonicalName != null && filterClassCanonicalName !== '')
		filters.push({ name: 'fq', value: 'classCanonicalName:' + filterClassCanonicalName });

	var filterClassSimpleName = $formFilters.find('.valueClassSimpleName').val();
	if(filterClassSimpleName != null && filterClassSimpleName !== '')
		filters.push({ name: 'fq', value: 'classSimpleName:' + filterClassSimpleName });

	var filterClassCanonicalNames = $formFilters.find('.valueClassCanonicalNames').val();
	if(filterClassCanonicalNames != null && filterClassCanonicalNames !== '')
		filters.push({ name: 'fq', value: 'classCanonicalNames:' + filterClassCanonicalNames });

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
			var $a = $('<a>').attr('href', o['pageUrl']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchBankAccountVals($formFilters, success, error);
}

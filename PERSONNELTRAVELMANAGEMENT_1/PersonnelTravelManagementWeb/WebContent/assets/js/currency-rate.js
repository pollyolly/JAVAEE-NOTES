$(document).ready(function() {
	//CAR
	$(".currencyCar").change(function(){
		var amount = $('.currencyCar').val();
		var currency = $('.amount2Car').val();
		var rate = amount * currency;	
		$('.amountCar').val(rate.toFixed(2));
	});
	$(".amount2Car").change(function(){
		var amount = $('.currencyCar').val();
		var currency = $('.amount2Car').val();
		var rate = amount * currency;
		$('.amountCar').val(rate.toFixed(2));
	});
	//CARL
	//HOTEL
	$(".currencyHotel").change(function(){
		var amount = $('.currencyHotel').val();
		var currency = $('.amount2Hotel').val();
		var rate = amount * currency;	
		$('.amountHotel').val(rate.toFixed(2));
	});
	$(".amount2Hotel").change(function(){
		var amount = $('.currencyHotel').val();
		var currency = $('.amount2Hotel').val();
		var rate = amount * currency;
		$('.amountHotel').val(rate.toFixed(2));
	});
	//HOTEL
	//FLIGHT
	$(".currencyFlight").change(function(){
		var amount = $('.currencyFlight').val();
		var currency = $('.amount2Flight').val();
		var rate = amount * currency;	
		$('.amountFlight').val(rate.toFixed(2));
	});
	$(".amount2Flight").change(function(){
		var amount = $('.currencyFlight').val();
		var currency = $('.amount2Flight').val();
		var rate = amount * currency;
		$('.amountFlight').val(rate.toFixed(2));
	});
	//FLIGHT
	//MILEAGE
	$(".currencyMileage").change(function(){
		var amount = $('.currencyMileage').val();
		var currency = $('.amount2Mileage').val();
		var rate = amount * currency;	
		$('.amountMileage').val(rate.toFixed(2));
	});
	$(".amount2Mileage").change(function(){
		var amount = $('.currencyMileage').val();
		var currency = $('.amount2Mileage').val();
		var rate = amount * currency;
		$('.amountMileage').val(rate.toFixed(2));
	});
	//MILEAGE
	//MEAL
	$(".currencyMeal").change(function(){
		var amount = $('.currencyMeal').val();
		var currency = $('.amount2Meal').val();
		var rate = amount * currency;	
		$('.amountMeal').val(rate.toFixed(2));
	});
	$(".amount2Meal").change(function(){
		var amount = $('.currencyMeal').val();
		var currency = $('.amount2Meal').val();
		var rate = amount * currency;
		$('.amountMeal').val(rate.toFixed(2));
	});
	//MEAL
	//MISC
	$(".currencyMisc").change(function(){
		var amount = $('.currencyMisc').val();
		var currency = $('.amount2Misc').val();
		var rate = amount * currency;	
		$('.amountMeal').val(rate.toFixed(2));
	});
	$(".amount2Misc").change(function(){
		var amount = $('.currencyMisc').val();
		var currency = $('.amount2Misc').val();
		var rate = amount * currency;
		$('.amountMisc').val(rate.toFixed(2));
	});
	//MISC
});
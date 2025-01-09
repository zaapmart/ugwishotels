$(document).ready(function(){
    $('.book-now').click(function(){
        $('#booking-section').slideDown(3000);
        $('html, body').scrollTop($("#booking-section").offset().top);
    });

    $('#room-select').change(function(){
        var roomId = $(this).val();
        var price = rooms[roomId];
        var formatedPrice = numberWithCommas(price);
        $('#room-cost').html('&#8358;' + formatedPrice + ' per night');
        calculateTotal();
    });

    $('#duration').change(function(){
        calculateTotal();
    });

    $('#quantity').change(function(){
        calculateTotal();
    });

    function calculateTotal(){
        var quantity = $('#quantity').val();
        var duration = $('#duration').val();
        var roomId = $('#room-select').val();
        var price = rooms[roomId];
        var total = parseFloat(price) * parseInt(quantity) * parseInt(duration);
        console.log('Price: ', parseFloat(price));
        console.log('Quantity: ', parseInt(quantity));
        console.log('Duration: ', parseInt(duration));
        $('#booking-total').html('&#8358;' + numberWithCommas(total));
        $('#total-amount').val(total);
    }

    $("#booking-form").submit(function(event){
        event.preventDefault();
        var data = $(this).serialize();
        $.ajax({
            url: '/submit-booking',
            data: data,
            dataType: 'JSON',
            method: 'POST',
            beforeSend: function(xhr){
                $('#submit-booking span').html();
                $('#submit-booking span').html('send');
                $('#submit-booking span').addClass('spin');
                $('#submit-booking').attr('disabled', true);
            },
            success: function(data, textStatus, jqXHR){
                if(data.status === 'success'){
                    Swal.fire({
                        icon: 'success',
                        title: 'Success!',
                        text: data.message
                    });
                    $('#booking-section').slideUp(3000);
                }else{
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: data.message
                    });
                }
            },
            complete: function(jqXHR, textStatus){
                $('#submit-booking').find('span').html('send');
                $('#submit-booking').find('span').removeClass('spin');
                $('#submit-booking').removeAttr('disabled');
            },
            error: function(jqXHR, textStatus, errorThrown){
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'There was an unknown error, please reload this page.'
                });
            }
        });
    });
});

function numberWithCommas(x){
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
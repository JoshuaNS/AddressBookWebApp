// // $(document).ready(function() {
// //     //$()
// //     showBuddyInfo: function(data, requestStatus, xhrObject) {
// //         var oneFourth = Math.ceil($(window).width() / 4);
// //         $('#BuddyInfo').
// //             css({'left': oneFourth, 'width': 2*oneFourth, 'top': 250})
// //             .html(data)
// //             .show();
// //         $('#closeLink').click(
// //     }
// //     $.ajax({
// //         url: "http://rest-service.guides.spring.io/greeting"
// //     }).then(function(data) {
// //         $('.greeting-id').append(data.id);
// //         $('.greeting-content').append(data.content);
// //     });
// // });
// $(document).ready(function() {
//     $('a').on('click', function(e) {
//         e.preventDefault();
//         var pageRef = $(this).attr('href');
//         callAboutPage(pageRef);
//     });
//
// });
// var callAboutPage = function(pageRefInput) {
//     $.ajax({
//         url:pageRefInput,
//         type:"GET",
//         dataType:'text',
//         success: function (response) {
//             console.log('Page loaded', response);
//             $('.content').html(response);
//         },
//         error: function (error) {
//             console.log('Page not loaded', error);
//         },
//
//     })
// };
//
//
//
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/AddressBook",
        dataType: 'json'
    }).then(function(data) {
        console.log(data);

        console.log(data._embedded.AddressBook);
        var book = data._embedded.AddressBook;

        var table = document.createElement("table");

        var tr = table.insertRow(-1);

        var col = ["Name", "Address", "Phone Number"];


        // Header
        for (var i = 0; i < col.length ; i++) {
            var th = document.createElement("th");
            th.innerHTML = col[i];
            tr.appendChild(th);
        }

        // JSON as rows
        for (var i = 0; i < book.length; i++) {
            addCell(table, book[i])
        }

        $.each(book, function(k, buddyInfo) {
            console.log(buddyInfo.name);
            console.log(buddyInfo.address);
            console.log(buddyInfo.phoneNumber);

        });

        var divContainer = document.getElementById("showData");
        divContainer.innerHTML = "";
        divContainer.appendChild(table);

    });

});

addCell = function(table, buddyInfo) {
    tr = table.insertRow(-1);
    tr.insertCell(-1).innerHTML = buddyInfo.name;
    tr.insertCell(-1).innerHTML = buddyInfo.address;
    tr.insertCell(-1).innerHTML = buddyInfo.phoneNumber;
};
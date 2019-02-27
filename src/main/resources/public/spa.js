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
        type:"GET",
        url: "/AddressBook",
        dataType: 'json'
    }).then(function(data) {
        var book = data._embedded.AddressBook;

        var table = document.createElement("table");
        table.setAttribute("id", "table1");

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
            tr = table.insertRow(-1);
            tr.insertCell(-1).innerHTML = book[i].name;
            tr.insertCell(-1).innerHTML = book[i].address;
            tr.insertCell(-1).innerHTML = book[i].phoneNumber;
        }



        var divContainer = document.getElementById("showData");
        divContainer.innerHTML = "";
        divContainer.appendChild(table);

    });
    $("#submitBuddy").click( function() {
        var name = document.getElementById("nameInput").value;
        var address = document.getElementById("addressInput").value;
        var phoneNumber = document.getElementById("phoneInput").value;
        var buddyInfo = {
            "name":name,
            "address":address,
            "phoneNumber":phoneNumber
        };

        $.ajax({
            type: "POST",
            url:"/AddressBook",
            contentType:"application/json",
            dataType: "json",
            data: JSON.stringify(buddyInfo),
            success:function(data) {setTimeout(function () {addCell(data)}, 50)}
        });

        return false;
    })


});

addCell = function(buddyInfo) {
    var table = $("#table1")[0];

    tr = table.insertRow(-1);
    tr.insertCell(-1).innerHTML = buddyInfo.name;
    tr.insertCell(-1).innerHTML = buddyInfo.address;
    tr.insertCell(-1).innerHTML = buddyInfo.phoneNumber;
};
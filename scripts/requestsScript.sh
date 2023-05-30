echo "Requesting all movies by chosen date (2023-06-14T09:40:00)"
echo "Response: "
curl 'http://localhost:8080/api/movies/all/byScreeningDate?screeningDate=2023-06-14T09:40:00' | jq

echo "Requesting information about available seats and screeningRoom for chosen screening (screening id = 1)"
echo "Response: "
curl 'http://localhost:8080/api/screenings/1' | jq

echo "Reserving tickets for chosen screening (screening id = 1) and chosen seats (seat ids = 4, 5, 6)"
echo "Response: "
curl -X POST -H "Content-Type: application/json" -d '{
  "name": "George",
  "surname": "Smith-Jones",
  "screeningId" : 1,
  "tickets": [
    {
        "ticketType": "ADULT",
        "seatId" : 4
    },
    {
        "ticketType": "CHILD",
        "seatId" : 5
    },
    {
        "ticketType": "STUDENT",
        "seatId" : 6
    }
  ]
}' http://localhost:8080/api/reservations/add | jq


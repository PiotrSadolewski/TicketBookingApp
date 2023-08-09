export interface ReservationResponse {
    name: string;
    surname: string;
    movieTitle: string;
    screeningRoomNumber: number;
    startTime: string;
    totalPrice: number;
    tickets: TicketResponse[];
    expirationTime: string;
}

export interface TicketResponse {
    ticketType: string;
    row: number;
    seatNumber: number;
    price: number;
}
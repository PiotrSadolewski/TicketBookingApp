import { TicketRequest } from "./ticket_request";

export interface ReservationRequest {
    Name: string;
    Surname: string;
    ScreeningId: number;
    Tickets: TicketR equest[];
}
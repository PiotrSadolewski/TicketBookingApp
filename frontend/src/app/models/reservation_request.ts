import { TicketRequest } from "./ticket_request";

export interface ReservationRequest {
    name: string;
    surname: string;
    screeningId: number;
    tickets: TicketRequest[];
}
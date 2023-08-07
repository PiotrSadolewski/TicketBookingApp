export interface ScreeningResponse {
    screeningRoomNumber: number;
    seats: Seat[];
}
  
export interface Seat {
    id: number;
    row: number;
    seatNumber: number;
    reserved: boolean;
}
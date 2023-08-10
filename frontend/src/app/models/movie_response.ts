export interface MovieResponse {
    id: number;
    title: string;
    screenings: Screening[];
    imageUrl: string;
    duration: string;
    genre: string;
}
  
export interface Screening {
    screeningId: number;
    startTime: string; 
}
  
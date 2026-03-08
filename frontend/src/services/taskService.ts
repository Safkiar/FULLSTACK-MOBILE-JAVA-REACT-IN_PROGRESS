import axiosClient from "../api/axiosClient";

export interface Task {
    id: string;
    title: string;
    text?: string;
    mark: boolean;
}

export const getTasks = async (): Promise<Task[]> => {
    const response = await axiosClient.get<Task[]>('/checkboxes'); 
    return response.data; 
};


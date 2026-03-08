import {useQuery} from '@tanstack/react-query';
import { getTasks } from '../../services/taskService';
import './TaskDebugger.scss';

const TaskDebugger = () => {
    const { data: tasks, isLoading, isError} = useQuery({
        queryKey: ['tasks'],
        queryFn: getTasks,
    })

    if(isLoading) return <p className='debugger-loading'>Ładowanie danych z Java</p>
    if(isError) return <p className='debugger-error'>Błąd. Sprawdź połączenie</p>


    return (
        <div className="task-debugger">
      <h2>Test połączenia: React 🤝 Java</h2>
      <div className="json-box">
        <pre>{JSON.stringify(tasks, null, 2)}</pre>
      </div>
    </div>
    )
}

export default TaskDebugger;


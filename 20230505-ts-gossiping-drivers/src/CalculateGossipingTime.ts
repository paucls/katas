export function calculateGossipingTime(routes: number[][]) {

    let allMeetAtInitialStop = true

    for (let i = 0; i < routes.length; i++) {
        if (routes[i + 1] === undefined) {
            break
        }

        if (routes[i][0] !== routes[i + 1][0]) {
            allMeetAtInitialStop = false
        }
    }

    if (allMeetAtInitialStop) {
        return '0'
    }

    return 'never'
}
